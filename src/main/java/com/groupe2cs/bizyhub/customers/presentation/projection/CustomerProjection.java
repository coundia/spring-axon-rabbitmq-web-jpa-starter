package com.groupe2cs.bizyhub.customers.presentation.projection;

	import com.groupe2cs.bizyhub.customers.domain.event.*;
	import com.groupe2cs.bizyhub.customers.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.customers.infrastructure.entity.*;
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
@ProcessingGroup("Customer")
public class CustomerProjection {

private final CustomerRepository repository;


@EventHandler
public void on(CustomerCreatedEvent event) {
try {
Customer entity = Customer.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.remoteId(event.getRemoteId() == null ? null : event.getRemoteId().value())
 		.code(event.getCode() == null ? null : event.getCode().value())
 		.firstName(event.getFirstName() == null ? null : event.getFirstName().value())
 		.lastName(event.getLastName() == null ? null : event.getLastName().value())
 		.fullName(event.getFullName() == null ? null : event.getFullName().value())
 		.balance(event.getBalance() == null ? null : event.getBalance().value())
 		.balanceDebt(event.getBalanceDebt() == null ? null : event.getBalanceDebt().value())
 		.phone(event.getPhone() == null ? null : event.getPhone().value())
 		.email(event.getEmail() == null ? null : event.getEmail().value())
 		.notes(event.getNotes() == null ? null : event.getNotes().value())
 		.status(event.getStatus() == null ? null : event.getStatus().value())
  		.company( event.getCompany() == null ? null : new com.groupe2cs.bizyhub.companies.infrastructure.entity.Company(event.getCompany().value()))
		.addressLine1(event.getAddressLine1() == null ? null : event.getAddressLine1().value())
 		.addressLine2(event.getAddressLine2() == null ? null : event.getAddressLine2().value())
 		.city(event.getCity() == null ? null : event.getCity().value())
 		.region(event.getRegion() == null ? null : event.getRegion().value())
 		.country(event.getCountry() == null ? null : event.getCountry().value())
 		.postalCode(event.getPostalCode() == null ? null : event.getPostalCode().value())
 		.syncAt(event.getSyncAt() == null ? null : event.getSyncAt().value())
 		.isActive(event.getIsActive() == null ? null : event.getIsActive().value())
 .build();

entity.setId(event.getId().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("Customer inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving Customer: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(CustomerUpdatedEvent event) {
try {
Customer entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("Customer not found"));


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getRemoteId() != null) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getCode() != null) {
		entity.setCode(event.getCode().value());
    }
	if(event.getFirstName() != null) {
		entity.setFirstName(event.getFirstName().value());
    }
	if(event.getLastName() != null) {
		entity.setLastName(event.getLastName().value());
    }
	if(event.getFullName() != null) {
		entity.setFullName(event.getFullName().value());
    }
	if(event.getBalance() != null) {
		entity.setBalance(event.getBalance().value());
    }
	if(event.getBalanceDebt() != null) {
		entity.setBalanceDebt(event.getBalanceDebt().value());
    }
	if(event.getPhone() != null) {
		entity.setPhone(event.getPhone().value());
    }
	if(event.getEmail() != null) {
		entity.setEmail(event.getEmail().value());
    }
	if(event.getNotes() != null) {
		entity.setNotes(event.getNotes().value());
    }
	if(event.getStatus() != null) {
		entity.setStatus(event.getStatus().value());
    }

     if(event.getCompany() != null) {
		  entity.setCompany(new com.groupe2cs.bizyhub.companies.infrastructure.entity.Company(event.getCompany().value()));
	  }
	if(event.getAddressLine1() != null) {
		entity.setAddressLine1(event.getAddressLine1().value());
    }
	if(event.getAddressLine2() != null) {
		entity.setAddressLine2(event.getAddressLine2().value());
    }
	if(event.getCity() != null) {
		entity.setCity(event.getCity().value());
    }
	if(event.getRegion() != null) {
		entity.setRegion(event.getRegion().value());
    }
	if(event.getCountry() != null) {
		entity.setCountry(event.getCountry().value());
    }
	if(event.getPostalCode() != null) {
		entity.setPostalCode(event.getPostalCode().value());
    }
	if(event.getSyncAt() != null) {
		entity.setSyncAt(event.getSyncAt().value());
    }
	if(event.getIsActive() != null) {
		entity.setIsActive(event.getIsActive().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("Customer updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating Customer: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(CustomerDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("Customer deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Customer: {}", e.getMessage(), e);
throw e;
}
}
}
