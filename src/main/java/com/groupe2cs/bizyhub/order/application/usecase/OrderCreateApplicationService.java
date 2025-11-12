package com.groupe2cs.bizyhub.order.application.usecase;

import com.groupe2cs.bizyhub.companies.infrastructure.entity.Company;
import com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository;
import com.groupe2cs.bizyhub.order.application.command.CreateOrderCommand;
import com.groupe2cs.bizyhub.order.application.dto.OrderRequest;
import com.groupe2cs.bizyhub.order.application.dto.OrderResponse;
import com.groupe2cs.bizyhub.order.application.mapper.OrderMapper;
import com.groupe2cs.bizyhub.order.domain.valueObject.OrderCreatedBy;
import com.groupe2cs.bizyhub.order.domain.valueObject.OrderTenant;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import com.groupe2cs.bizyhub.shared.application.NotificationService;
import com.groupe2cs.bizyhub.shared.application.Validators;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderCreateApplicationService {

	private final CommandGateway commandGateway;
	private final NotificationService notificationService;

	// Repos lecture
	private final ProductRepository productReadRepository;
	private final CompanyRepository companyReadRepository;

	@Value("${spring.mail.username:noreply@pcoundia.com}")
	private String defaultFrom;

	@Value("${app.notifications.sales-to:}")
	private String salesTo; // destinataire interne optionnel

	private static String safe(String s) {
		return s == null ? "" : s;
	}

	private static String safe(Object o) {
		return o == null ? "" : String.valueOf(o);
	}

	/* ==================== Helpers ==================== */

	private static long safeInt(Integer i) {
		return i == null ? 0 : i;
	}

	private static Number safeNum(Number n) {
		return n == null ? 0 : n;
	}

	private static long centsToXof(Number cents) {
		if (cents == null) return 0;
		try {
			return cents.longValue() / 100L;
		} catch (Exception e) {
			return 0;
		}
	}

	// Protège minimalement contre l'injection HTML dans nos fragments interpolés
	private static String escape(String v) {
		if (v == null) return "";
		return v.replace("&", "&amp;")
				.replace("<", "&lt;")
				.replace(">", "&gt;");
	}

	public OrderResponse createOrder(OrderRequest request, MetaRequest metaRequest) {
		// 1) Construire & publier la commande
		CreateOrderCommand command = OrderMapper.toCommand(request);
		command.setCreatedBy(OrderCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(OrderTenant.create(metaRequest.getTenantId()));
		commandGateway.sendAndWait(command);

		// 2) Mapper la réponse
		OrderResponse response = OrderMapper.toResponse(command);

		// 3) Envoi d’e-mails en "fire-and-forget" (async, on n’attend pas)
		CompletableFuture.runAsync(() -> {
			try {
				createTransactionAfterCreate(request, response, metaRequest);
				sendEmailsAfterCreate(request, response, metaRequest.getTenantId());
			} catch (Exception mailEx) {
				log.error("Email notification failed: {}", mailEx.getMessage(), mailEx);
			}
		});

		return response;
	}

	/* ===========================================================
	   =           Notifications e-mail après création           =
	   =========================================================== */
	private void sendEmailsAfterCreate(OrderRequest req, OrderResponse res, String tenantId) {
		// --- Lecture produit
		final String productId = req.getProductId();
		Optional<Product> productOpt = StringUtils.hasText(productId)
				? productReadRepository.findById(productId)
				: Optional.empty();

		final String productName = productOpt.map(Product::getName)
				.filter(StringUtils::hasText).orElse("Produit");

		// product.defaultPrice est généralement en XOF "unitaires".
		// Ici req.amountCents est en CENTS. On convertit pour affichage.
		final Double productUnitXof = productOpt.map(Product::getDefaultPrice).orElse(null);

		// --- Lecture boutique
		final String companyId = productOpt.map(Product::getCompany).orElse(null);
		Optional<Company> companyOpt = StringUtils.hasText(companyId)
				? companyReadRepository.findById(companyId)
				: Optional.empty();

		final String companyName = companyOpt.map(Company::getName)
				.filter(StringUtils::hasText).orElse("Boutique");
		final String companyEmail = companyOpt.map(Company::getEmail)
				.filter(StringUtils::hasText).orElse(null);

		// --- Type
		final String type = safe(req.getTypeOrder()); // "MESSAGE" | "COMMAND" | autre
		final boolean isMessage = "MESSAGE".equalsIgnoreCase(type);

		// --- Montants & quantités
		// req.amountCents => centimes ; on convertit pour affichage en XOF
		final long xofDisplayed = centsToXof(req.getAmountCents());
		int qty = (int) safeInt(req.getQuantity());
		if (qty <= 0) qty = 1;

		// --- Sujet
		final String subject = (isMessage
				? "[BizyHub] Nouveau message d’intérêt"
				: "[BizyHub] Nouvelle commande")
				+ " — " + productName + " • " + companyName;

		// --- Corps HTML (mieux rendu sous Spring Mail)
		final String html = isMessage
				? """
				<div style="font-family: system-ui, -apple-system, Segoe UI, Roboto, Arial, sans-serif; line-height:1.5; color:#111;">
				  <p>Bonjour <strong>%s</strong>,</p>
				  <p>Un nouveau <strong>message d’intérêt</strong> a été enregistré pour votre boutique <strong>%s</strong>.</p>
				
				  <table cellpadding="0" cellspacing="0" style="border-collapse: collapse; margin:12px 0; width:100%%; max-width:640px;">
				    <tbody>
				      <tr>
				        <td style="padding:6px 0; width:180px; color:#555;">Produit :</td>
				        <td style="padding:6px 0;"><strong>%s</strong></td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Type :</td>
				        <td style="padding:6px 0;">MESSAGE</td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Identifiant :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Téléphone :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Email client :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Message :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				    </tbody>
				  </table>
				
				  <hr style="border:none; border-top:1px solid #eee; margin:12px 0;" />
				
				  <table cellpadding="0" cellspacing="0" style="border-collapse: collapse; margin:12px 0; width:100%%; max-width:640px;">
				    <tbody>
				      <tr>
				        <td style="padding:6px 0; width:180px; color:#555;">Référence :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Montant affiché :</td>
				        <td style="padding:6px 0;"><strong>%s XOF</strong></td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Quantité :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Locataire (tenant) :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				    </tbody>
				  </table>
				
				  <p style="color:#666; font-size:13px;">Prix unitaire (catalogue) : %s XOF</p>
				  <p>Cordialement,<br/>BizyHub</p>
				</div>
				""".formatted(
				companyName,
				companyName,
				productName,
				escape(req.getIdentifiant()),
				escape(req.getTelephone()),
				escape(req.getMail()),
				escape(req.getMessage()),
				safe(res != null ? res.getId() : null),
				xofDisplayed,
				qty,
				escape(tenantId),
				productUnitXof != null ? productUnitXof.longValue() : 0L
		)
				: """
				<div style="font-family: system-ui, -apple-system, Segoe UI, Roboto, Arial, sans-serif; line-height:1.5; color:#111;">
				  <p>Bonjour <strong>%s</strong>,</p>
				  <p>Une nouvelle <strong>commande</strong> a été enregistrée pour votre boutique <strong>%s</strong>.</p>
				
				  <table cellpadding="0" cellspacing="0" style="border-collapse: collapse; margin:12px 0; width:100%%; max-width:640px;">
				    <tbody>
				      <tr>
				        <td style="padding:6px 0; width:180px; color:#555;">Produit :</td>
				        <td style="padding:6px 0;"><strong>%s</strong></td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Type :</td>
				        <td style="padding:6px 0;">COMMANDE</td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Identifiant :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Téléphone :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Email client :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Nom acheteur :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Adresse :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Notes :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				    </tbody>
				  </table>
				
				  <hr style="border:none; border-top:1px solid #eee; margin:12px 0;" />
				
				  <table cellpadding="0" cellspacing="0" style="border-collapse: collapse; margin:12px 0; width:100%%; max-width:640px;">
				    <tbody>
				      <tr>
				        <td style="padding:6px 0; width:180px; color:#555;">Référence :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Montant payé :</td>
				        <td style="padding:6px 0;"><strong>%s XOF</strong> </td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Quantité :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				      <tr>
				        <td style="padding:6px 0; color:#555;">Locataire (tenant) :</td>
				        <td style="padding:6px 0;">%s</td>
				      </tr>
				    </tbody>
				  </table>
				
				  <p style="color:#666; font-size:13px;">Prix unitaire (catalogue) : %s XOF</p>
				  <p>Cordialement,<br/>BizyHub</p>
				</div>
				""".formatted(
				companyName,
				companyName,
				productName,
				escape(req.getIdentifiant()),
				escape(req.getTelephone()),
				escape(req.getMail()),
				escape(req.getBuyerName()),
				escape(req.getAddress()),
				escape(req.getNotes()),
				safe(res != null ? res.getId() : null),
				xofDisplayed,
				qty,
				escape(tenantId),
				productUnitXof != null ? productUnitXof.longValue() : 0L
		);

		final String from = StringUtils.hasText(defaultFrom) ? defaultFrom : "no-reply@bizyhub.local";


		if (StringUtils.hasText(req.getMail()) && Validators.isValidMail(req.getMail())) {
			notificationService.notifyByEmail(from, req.getMail(), subject, html);
		} else {
			log.info("Skip customer email — no recipient in request.mail");
		}

		// 2) Boutique (si connue)
		if (StringUtils.hasText(companyEmail) && Validators.isValidMail(companyEmail)) {
			notificationService.notifyByEmail(from, companyEmail, subject, html);
		} else {
			log.info("Skip company email — not found for productId={} companyId={}", productId, companyId);
		}

		// 3) Interne (optionnel)
		if (StringUtils.hasText(salesTo) && Validators.isValidMail(salesTo)) {
			notificationService.notifyByEmail(from, salesTo, subject, html);
		}
	}

	private void createTransactionAfterCreate(OrderRequest req, OrderResponse res, MetaRequest meta) {
		final String productId = req.getProductId();
		final Optional<Product>
				productOpt =
				StringUtils.hasText(productId) ? productReadRepository.findById(productId) : Optional.empty();
		final String productName = productOpt.map(Product::getName).filter(StringUtils::hasText).orElse("Produit");
		final String categoryId = productOpt.map(Product::getCategory).orElse(null);
		final String companyId = productOpt.map(Product::getCompany).orElse(null);
		final String accountId = productOpt.map(Product::getAccount).orElse(null);

		if (req.getTypeOrder() != null && req.getTypeOrder().equalsIgnoreCase("MESSAGE")) {
			// Pas de transaction pour un simple message d’intérêt
			log.warn("Skip transaction creation for MESSAGE type order");
			return;
		}

		final String createdById = productOpt.map(Product::getCreatedBy).map(u -> u.getId()).orElse(null);

		final String
				codeVal =
				res != null && StringUtils.hasText(res.getId()) ? res.getId() : UUID.randomUUID().toString();
		final Double amountXof = req.getAmountCents() != null ? req.getAmountCents() : 0.0;
		final java.time.Instant when = req.getDateCommand() != null ? req.getDateCommand() : java.time.Instant.now();
		final String typeVal = StringUtils.hasText(req.getTypeOrder()) ? req.getTypeOrder() : "COMMAND";
		String
				descVal =
				(typeVal +
						" • " +
						productName +
						" • qty=" +
						(req.getQuantity() == null ? 1 : req.getQuantity())).trim();

		descVal = descVal + " • Client:  " + (StringUtils.hasText(req.getBuyerName()) ? req.getBuyerName() : "Anonyme");
		descVal = descVal + " • Tel:  " + (StringUtils.hasText(req.getTelephone()) ? req.getTelephone() : "NC");
		descVal = descVal + " • Email:  " + (StringUtils.hasText(req.getMail()) ? req.getMail() : "NC");
		descVal = descVal + " • Montant:  " + amountXof / 100 + " XOF";

		CreateTransactionCommand command = CreateTransactionCommand.builder()
				//.remoteId(StringUtils.hasText(req.getRemoteId()) ? TransactionRemoteId.create(req.getRemoteId()) : null)
				.localId(StringUtils.hasText(req.getLocalId()) ? TransactionLocalId.create(req.getLocalId()) : null)
				.code(TransactionCode.create(codeVal))
				.description(TransactionDescription.create(descVal))
				.amount(TransactionAmount.create(amountXof))
				.typeEntry(TransactionTypeEntry.create("COMMAND"))
				.dateTransaction(TransactionDateTransaction.create(when))
				.status(TransactionStatus.create("INIT"))
				.entityName(TransactionEntityName.create("orders"))
				.entityId(TransactionEntityId.create(res != null && StringUtils.hasText(res.getId()) ?
						res.getId() :
						""))
				//.account(StringUtils.hasText(accountId) ? TransactionAccount.create(accountId) : null)
				.syncAt(TransactionSyncAt.create(java.time.Instant.now()))
				.category(StringUtils.hasText(categoryId) ? TransactionCategory.create(categoryId) : null)
				.company(StringUtils.hasText(companyId) ? TransactionCompany.create(companyId) : null)
				//.customer(StringUtils.hasText(meta.getUserId()) ? TransactionCustomer.create(meta.getUserId()) : null)
				//.debt(null)
				.createdBy(TransactionCreatedBy.create(createdById))
				.tenant(TransactionTenant.create(meta.getTenantId()))
				.build();

		commandGateway.sendAndWait(command);


	}
}
