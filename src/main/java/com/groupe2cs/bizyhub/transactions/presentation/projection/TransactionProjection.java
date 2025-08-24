package com.groupe2cs.bizyhub.transactions.presentation.projection;

	import com.groupe2cs.bizyhub.transactions.domain.event.*;
	import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
	import org.axonframework.eventhandling.EventHandler;

import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.config.ProcessingGroup;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

@AllowReplay(value = false)
@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
@ProcessingGroup("Transaction")
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
 		.remoteId(event.getRemoteId() == null ? null : event.getRemoteId().value())
 		.localId(event.getLocalId() == null ? null : event.getLocalId().value())
 		.details(event.getDetails() == null ? null : event.getDetails().value())
 		.isActive(event.getIsActive() == null ? null : event.getIsActive().value())
 		.syncAt(event.getSyncAt() == null ? null : event.getSyncAt().value())
  		.account( event.getAccount() == null ? null : new com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account(event.getAccount().value()))
 		.category( event.getCategory() == null ? null : new com.groupe2cs.bizyhub.categories.infrastructure.entity.Category(event.getCategory().value()))
		.typeEntry(event.getTypeEntry() == null ? null : event.getTypeEntry().value())
 		.typeTransactionRaw(event.getTypeTransactionRaw() == null ? null : event.getTypeTransactionRaw().value())
 		.dateTransaction(event.getDateTransaction() == null ? null : event.getDateTransaction().value())
 .build();

entity.setId(event.getId().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);

this.applyTransactionToAccount(entity.getAccount().getId(),entity.getAmount(),entity.getTypeTransactionRaw());

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

 this.refundTransaction(entity.getAccount().getId(),entity.getAmount(),entity.getTypeTransactionRaw());

	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getName() != null) {
		entity.setName(event.getName().value());
    }
	if(event.getAmount() != null) {
		entity.setAmount(event.getAmount().value());
    }
	if(event.getRemoteId() != null) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getLocalId() != null) {
		entity.setLocalId(event.getLocalId().value());
    }
	if(event.getDetails() != null) {
		entity.setDetails(event.getDetails().value());
    }
	if(event.getIsActive() != null) {
		entity.setIsActive(event.getIsActive().value());
    }
	if(event.getSyncAt() != null) {
		entity.setSyncAt(event.getSyncAt().value());
    }

     if(event.getAccount() != null) {
		  entity.setAccount(new com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account(event.getAccount().value()));
	  }

     if(event.getCategory() != null) {
		  entity.setCategory(new com.groupe2cs.bizyhub.categories.infrastructure.entity.Category(event.getCategory().value()));
	  }
	if(event.getTypeEntry() != null) {
		entity.setTypeEntry(event.getTypeEntry().value());
    }
	if(event.getTypeTransactionRaw() != null) {
		entity.setTypeTransactionRaw(event.getTypeTransactionRaw().value());
    }
	if(event.getDateTransaction() != null) {
		entity.setDateTransaction(event.getDateTransaction().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);

this.applyTransactionToAccount(entity.getAccount().getId(),entity.getAmount(),entity.getTypeTransactionRaw());

log.info("Transaction updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating Transaction: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(TransactionDeletedEvent event) {
try {

Transaction entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("Transaction not found"));
this.refundTransaction(entity.getAccount().getId(),entity.getAmount(),entity.getTypeTransactionRaw());

repository.deleteById(event.getId().value());
log.info("Transaction deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Transaction: {}", e.getMessage(), e);
throw e;
}
}
public void applyTransactionToAccount(String accountId, Double amount, String type) {

		log.info("Applying transaction to account: {}, amount: {}, type: {}", accountId, amount, type);
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new RuntimeException("Account not found"));

		if(amount < 0) {
			log.error("Transaction amount cannot be negative: {}", amount);
			throw new IllegalArgumentException("Transaction amount cannot be negative");
		}

		if ("IN".equalsIgnoreCase(type) ) {
			account.setBalance(account.getBalance() + amount);
			log.info("Account updated with credit amount: {}, account:{}", amount, account.getId());
		}

		if ("OUT".equalsIgnoreCase(type)) {
			account.setBalance(account.getBalance() - amount);
			log.info("Account updated with debit amount: {}, account:{}", amount, account.getId());
		}

		//account.setUpdatedAt(java.time.Instant.now());
		accountRepository.save(account);
	}

	public void refundTransaction(String accountId, Double amount, String type) {
		log.info("Refunding transaction for account: {}, amount: {}, type: {}", accountId, amount, type);
		String reverseType = "IN".equalsIgnoreCase(type) ? "OUT" : "IN";
		applyTransactionToAccount(accountId, amount, reverseType);
	}
}
