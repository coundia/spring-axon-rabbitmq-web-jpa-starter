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
import lombok.RequiredArgsConstructor;

@AllowReplay(value = false)
@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
@ProcessingGroup("TransactionEntry")
public class TransactionEntryProjection {

private final TransactionEntryRepository repository;


@EventHandler
public void on(TransactionEntryCreatedEvent event) {
try {
TransactionEntry entity = TransactionEntry.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.remoteId(event.getRemoteId() == null ? null : event.getRemoteId().value())
 		.code(event.getCode() == null ? null : event.getCode().value())
 		.description(event.getDescription() == null ? null : event.getDescription().value())
 		.amount(event.getAmount() == null ? null : event.getAmount().value())
 		.typeEntry(event.getTypeEntry() == null ? null : event.getTypeEntry().value())
 		.dateTransaction(event.getDateTransaction() == null ? null : event.getDateTransaction().value())
 		.status(event.getStatus() == null ? null : event.getStatus().value())
 		.entityName(event.getEntityName() == null ? null : event.getEntityName().value())
 		.entityId(event.getEntityId() == null ? null : event.getEntityId().value())
  		.account( event.getAccount() == null ? null : new com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account(event.getAccount().value()))
		.syncAt(event.getSyncAt() == null ? null : event.getSyncAt().value())
  		.category( event.getCategory() == null ? null : new com.groupe2cs.bizyhub.categories.infrastructure.entity.Category(event.getCategory().value()))
 		.company( event.getCompany() == null ? null : new com.groupe2cs.bizyhub.companies.infrastructure.entity.Company(event.getCompany().value()))
 		.customer( event.getCustomer() == null ? null : new com.groupe2cs.bizyhub.customers.infrastructure.entity.Customer(event.getCustomer().value()))
 		.debt( event.getDebt() == null ? null : new com.groupe2cs.bizyhub.debts.infrastructure.entity.Debt(event.getDebt().value()))
.build();

entity.setId(event.getId().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("TransactionEntry inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving TransactionEntry: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(TransactionEntryUpdatedEvent event) {
try {
TransactionEntry entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("TransactionEntry not found"));


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getRemoteId() != null) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getCode() != null) {
		entity.setCode(event.getCode().value());
    }
	if(event.getDescription() != null) {
		entity.setDescription(event.getDescription().value());
    }
	if(event.getAmount() != null) {
		entity.setAmount(event.getAmount().value());
    }
	if(event.getTypeEntry() != null) {
		entity.setTypeEntry(event.getTypeEntry().value());
    }
	if(event.getDateTransaction() != null) {
		entity.setDateTransaction(event.getDateTransaction().value());
    }
	if(event.getStatus() != null) {
		entity.setStatus(event.getStatus().value());
    }
	if(event.getEntityName() != null) {
		entity.setEntityName(event.getEntityName().value());
    }
	if(event.getEntityId() != null) {
		entity.setEntityId(event.getEntityId().value());
    }

     if(event.getAccount() != null) {
		  entity.setAccount(new com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account(event.getAccount().value()));
	  }
	if(event.getSyncAt() != null) {
		entity.setSyncAt(event.getSyncAt().value());
    }

     if(event.getCategory() != null) {
		  entity.setCategory(new com.groupe2cs.bizyhub.categories.infrastructure.entity.Category(event.getCategory().value()));
	  }

     if(event.getCompany() != null) {
		  entity.setCompany(new com.groupe2cs.bizyhub.companies.infrastructure.entity.Company(event.getCompany().value()));
	  }

     if(event.getCustomer() != null) {
		  entity.setCustomer(new com.groupe2cs.bizyhub.customers.infrastructure.entity.Customer(event.getCustomer().value()));
	  }

     if(event.getDebt() != null) {
		  entity.setDebt(new com.groupe2cs.bizyhub.debts.infrastructure.entity.Debt(event.getDebt().value()));
	  }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("TransactionEntry updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating TransactionEntry: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(TransactionEntryDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("TransactionEntry deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting TransactionEntry: {}", e.getMessage(), e);
throw e;
}
}
}
