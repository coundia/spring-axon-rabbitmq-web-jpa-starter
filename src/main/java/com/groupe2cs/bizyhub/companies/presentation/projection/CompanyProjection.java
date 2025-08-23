package com.groupe2cs.bizyhub.companies.presentation.projection;

	import com.groupe2cs.bizyhub.companies.domain.event.*;
	import com.groupe2cs.bizyhub.companies.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.companies.infrastructure.entity.*;
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
@ProcessingGroup("Company")
public class CompanyProjection {

private final CompanyRepository repository;


@EventHandler
public void on(CompanyCreatedEvent event) {
try {
Company entity = Company.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.remoteId(event.getRemoteId() == null ? null : event.getRemoteId().value())
 		.code(event.getCode() == null ? null : event.getCode().value())
 		.name(event.getName() == null ? null : event.getName().value())
 		.description(event.getDescription() == null ? null : event.getDescription().value())
 		.phone(event.getPhone() == null ? null : event.getPhone().value())
 		.email(event.getEmail() == null ? null : event.getEmail().value())
 		.website(event.getWebsite() == null ? null : event.getWebsite().value())
 		.taxId(event.getTaxId() == null ? null : event.getTaxId().value())
 		.currency(event.getCurrency() == null ? null : event.getCurrency().value())
 		.addressLine1(event.getAddressLine1() == null ? null : event.getAddressLine1().value())
 		.addressLine2(event.getAddressLine2() == null ? null : event.getAddressLine2().value())
 		.city(event.getCity() == null ? null : event.getCity().value())
 		.region(event.getRegion() == null ? null : event.getRegion().value())
 		.country(event.getCountry() == null ? null : event.getCountry().value())
 		.postalCode(event.getPostalCode() == null ? null : event.getPostalCode().value())
 		.isActive(event.getIsActive() == null ? null : event.getIsActive().value())
 		.syncAt(event.getSyncAt() == null ? null : event.getSyncAt().value())
 		.isDefault(event.getIsDefault() == null ? null : event.getIsDefault().value())
 .build();

entity.setId(event.getId().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("Company inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving Company: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(CompanyUpdatedEvent event) {
try {
Company entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("Company not found"));


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getRemoteId() != null) {
		entity.setRemoteId(event.getRemoteId().value());
    }
	if(event.getCode() != null) {
		entity.setCode(event.getCode().value());
    }
	if(event.getName() != null) {
		entity.setName(event.getName().value());
    }
	if(event.getDescription() != null) {
		entity.setDescription(event.getDescription().value());
    }
	if(event.getPhone() != null) {
		entity.setPhone(event.getPhone().value());
    }
	if(event.getEmail() != null) {
		entity.setEmail(event.getEmail().value());
    }
	if(event.getWebsite() != null) {
		entity.setWebsite(event.getWebsite().value());
    }
	if(event.getTaxId() != null) {
		entity.setTaxId(event.getTaxId().value());
    }
	if(event.getCurrency() != null) {
		entity.setCurrency(event.getCurrency().value());
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
	if(event.getIsActive() != null) {
		entity.setIsActive(event.getIsActive().value());
    }
	if(event.getSyncAt() != null) {
		entity.setSyncAt(event.getSyncAt().value());
    }
	if(event.getIsDefault() != null) {
		entity.setIsDefault(event.getIsDefault().value());
    }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("Company updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating Company: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(CompanyDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("Company deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Company: {}", e.getMessage(), e);
throw e;
}
}
}
