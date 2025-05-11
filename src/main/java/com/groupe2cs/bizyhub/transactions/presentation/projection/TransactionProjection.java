package com.groupe2cs.bizyhub.transactions.presentation.projection;

import com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionCreatedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionDeletedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionUpdatedEvent;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@AllowReplay(value = false)
@Slf4j
@Component
@ProcessingGroup("Transaction")

@RequiredArgsConstructor
public class TransactionProjection {

	private final TransactionRepository repository;

	private final AccountRepository accountRepository;

	@EventHandler
	public void on(TransactionCreatedEvent event) {
		try {
			Transaction entity = Transaction.builder()
					.id(event.getId() == null ? null : event.getId().value())
					.name(event.getName() == null ? null : event.getName().value())
					.amount(event.getAmount() == null ? null : event.getAmount().value())
					.details(event.getDetails() == null ? null : event.getDetails().value())
					.isActive(event.getIsActive() == null ? null : event.getIsActive().value())
					.account(event.getAccount() == null ?
							null :
							new com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account(event.getAccount()
									.value()))
					.category(event.getCategory() == null ?
							null :
							new com.groupe2cs.bizyhub.categories.infrastructure.entity.Category(event.getCategory()
									.value()))
					.typeTransactionRaw(event.getTypeTransactionRaw() == null ?
							null :
							event.getTypeTransactionRaw().value())
					.dateTransaction(event.getDateTransaction() == null ? null : event.getDateTransaction().value())
					.updatedAt(event.getUpdatedAt() == null ? null : event.getUpdatedAt().value())
					.reference(event.getReference() == null ? null : event.getReference().value())
					.build();

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}
			var saved = repository.save(entity);

			log.info("Transaction created successfully: {}", saved.getId());

			Account account = accountRepository.findById(event.getAccount().value())
					.orElseThrow(() -> new RuntimeException("Account not found"));

			boolean isCredit = "IN".equalsIgnoreCase(entity.getTypeTransactionRaw());
			boolean isDebit = "OUT".equalsIgnoreCase(entity.getTypeTransactionRaw());

			if (isCredit) {
				account.setCurrentBalance(account.getCurrentBalance() + entity.getAmount());
				account.setUpdatedAt(entity.getUpdatedAt());
				log.info("Account updated with credit amount: {}, account:{}", entity.getAmount(), account.getId());

			}

			if (isDebit) {
				account.setCurrentBalance(account.getCurrentBalance() - entity.getAmount());
				account.setUpdatedAt(entity.getUpdatedAt());
				log.info("Account updated with debit  amount: {}, account:{}", entity.getAmount(), account.getId());
			}

			accountRepository.save(account);

			log.info("Transaction inserted: {}", entity);
		} catch (Exception e) {
			log.error("Error saving Transaction: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(TransactionUpdatedEvent event) {
		try {
			Transaction entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("Transaction not found"));

			entity.setId(event.getId().value());
			entity.setName(event.getName().value());
			entity.setAmount(event.getAmount().value());
			entity.setDetails(event.getDetails().value());
			entity.setIsActive(event.getIsActive().value());
			entity.setAccount(new com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account(event.getAccount()
					.value()));
			entity.setCategory(new com.groupe2cs.bizyhub.categories.infrastructure.entity.Category(event.getCategory()
					.value()));
			entity.setTypeTransactionRaw(event.getTypeTransactionRaw().value());
			entity.setDateTransaction(event.getDateTransaction().value());
			entity.setUpdatedAt(event.getUpdatedAt().value());
			entity.setReference(event.getReference().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}

			if (entity.getTenant() == null && event.getTenant() != null) {
				log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}",
						event.getTenant().value());
				entity.setTenant(new Tenant(event.getTenant().value()));
			}

			repository.save(entity);
			log.info("Transaction updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating Transaction: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(TransactionDeletedEvent event) {
		try {
			repository.deleteById(event.getId().value());
			log.info("Transaction deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting Transaction: {}", e.getMessage(), e);
			throw e;
		}
	}
}
