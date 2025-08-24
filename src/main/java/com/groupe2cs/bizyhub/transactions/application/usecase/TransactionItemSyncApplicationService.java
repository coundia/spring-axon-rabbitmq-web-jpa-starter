package com.groupe2cs.bizyhub.transactions.application.usecase;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class TransactionItemSyncApplicationService {

	private final TransactionItemGate gateService;
	private final CommandGateway commandGateway;

	public void syncTransactionItem(TransactionItemSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateTransactionItemCommand command = CreateTransactionItemCommand.builder()
								.transaction(TransactionItemTransaction.create(d.getTransaction()))
								.product(TransactionItemProduct.create(d.getProduct()))
								.label(TransactionItemLabel.create(d.getLabel()))
								.quantity(TransactionItemQuantity.create(d.getQuantity()))
								.unit(TransactionItemUnit.create(d.getUnit()))
								.remoteId(TransactionItemRemoteId.create(d.getRemoteId()))
								.syncAt(TransactionItemSyncAt.create(d.getSyncAt()))
								.unitPrice(TransactionItemUnitPrice.create(d.getUnitPrice()))
								.total(TransactionItemTotal.create(d.getTotal()))
								.notes(TransactionItemNotes.create(d.getNotes()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(TransactionItemTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(TransactionItemCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update TransactionItem with id " + d.getId());
					}

					UpdateTransactionItemCommand update = UpdateTransactionItemCommand.builder()
							.id(TransactionItemId.create(d.getId()))
							.transaction(TransactionItemTransaction.create(d.getTransaction()))
							.product(TransactionItemProduct.create(d.getProduct()))
							.label(TransactionItemLabel.create(d.getLabel()))
							.quantity(TransactionItemQuantity.create(d.getQuantity()))
							.unit(TransactionItemUnit.create(d.getUnit()))
							.remoteId(TransactionItemRemoteId.create(d.getRemoteId()))
							.syncAt(TransactionItemSyncAt.create(d.getSyncAt()))
							.unitPrice(TransactionItemUnitPrice.create(d.getUnitPrice()))
							.total(TransactionItemTotal.create(d.getTotal()))
							.notes(TransactionItemNotes.create(d.getNotes()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete TransactionItem with id " + d.getId());
					}

					DeleteTransactionItemCommand delete = DeleteTransactionItemCommand.builder()
						.id(TransactionItemId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
