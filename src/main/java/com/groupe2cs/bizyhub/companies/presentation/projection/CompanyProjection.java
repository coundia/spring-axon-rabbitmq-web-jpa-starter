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


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(CompanyCreatedEvent event) {
		try {
			Company entity = Company.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getCode() != null && hasId(event.getCode().value())) {
				entity.setCode(event.getCode().value());
			}
			if (event.getName() != null && hasId(event.getName().value())) {
				entity.setName(event.getName().value());
			}
			if (event.getDescription() != null && hasId(event.getDescription().value())) {
				entity.setDescription(event.getDescription().value());
			}
			if (event.getPhone() != null && hasId(event.getPhone().value())) {
				entity.setPhone(event.getPhone().value());
			}
			if (event.getEmail() != null && hasId(event.getEmail().value())) {
				entity.setEmail(event.getEmail().value());
			}
			if (event.getWebsite() != null && hasId(event.getWebsite().value())) {
				entity.setWebsite(event.getWebsite().value());
			}
			if (event.getTaxId() != null && hasId(event.getTaxId().value())) {
				entity.setTaxId(event.getTaxId().value());
			}
			if (event.getCurrency() != null && hasId(event.getCurrency().value())) {
				entity.setCurrency(event.getCurrency().value());
			}
			if (event.getAddressLine1() != null && hasId(event.getAddressLine1().value())) {
				entity.setAddressLine1(event.getAddressLine1().value());
			}
			if (event.getAddressLine2() != null && hasId(event.getAddressLine2().value())) {
				entity.setAddressLine2(event.getAddressLine2().value());
			}
			if (event.getCity() != null && hasId(event.getCity().value())) {
				entity.setCity(event.getCity().value());
			}
			if (event.getRegion() != null && hasId(event.getRegion().value())) {
				entity.setRegion(event.getRegion().value());
			}
			if (event.getCountry() != null && hasId(event.getCountry().value())) {
				entity.setCountry(event.getCountry().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getPostalCode() != null && hasId(event.getPostalCode().value())) {
				entity.setPostalCode(event.getPostalCode().value());
			}
			if (event.getIsActive() != null && hasId(event.getIsActive().value())) {
				entity.setIsActive(event.getIsActive().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getIsPublic() != null && hasId(event.getIsPublic().value())) {
				entity.setIsPublic(event.getIsPublic().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getIsDefault() != null && hasId(event.getIsDefault().value())) {
				entity.setIsDefault(event.getIsDefault().value());
			}


			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}

			if (event.getRemoteId().value() == null) {
				entity.setRemoteId(event.getId().value());
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


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getCode() != null && hasId(event.getCode().value())) {
				entity.setCode(event.getCode().value());
			}
			if (event.getName() != null && hasId(event.getName().value())) {
				entity.setName(event.getName().value());
			}
			if (event.getDescription() != null && hasId(event.getDescription().value())) {
				entity.setDescription(event.getDescription().value());
			}
			if (event.getPhone() != null && hasId(event.getPhone().value())) {
				entity.setPhone(event.getPhone().value());
			}
			if (event.getEmail() != null && hasId(event.getEmail().value())) {
				entity.setEmail(event.getEmail().value());
			}
			if (event.getWebsite() != null && hasId(event.getWebsite().value())) {
				entity.setWebsite(event.getWebsite().value());
			}
			if (event.getTaxId() != null && hasId(event.getTaxId().value())) {
				entity.setTaxId(event.getTaxId().value());
			}
			if (event.getCurrency() != null && hasId(event.getCurrency().value())) {
				entity.setCurrency(event.getCurrency().value());
			}
			if (event.getAddressLine1() != null && hasId(event.getAddressLine1().value())) {
				entity.setAddressLine1(event.getAddressLine1().value());
			}
			if (event.getAddressLine2() != null && hasId(event.getAddressLine2().value())) {
				entity.setAddressLine2(event.getAddressLine2().value());
			}
			if (event.getCity() != null && hasId(event.getCity().value())) {
				entity.setCity(event.getCity().value());
			}
			if (event.getRegion() != null && hasId(event.getRegion().value())) {
				entity.setRegion(event.getRegion().value());
			}
			if (event.getCountry() != null && hasId(event.getCountry().value())) {
				entity.setCountry(event.getCountry().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getPostalCode() != null && hasId(event.getPostalCode().value())) {
				entity.setPostalCode(event.getPostalCode().value());
			}
			if (event.getIsActive() != null && hasId(event.getIsActive().value())) {
				entity.setIsActive(event.getIsActive().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getIsPublic() != null && hasId(event.getIsPublic().value())) {
				entity.setIsPublic(event.getIsPublic().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getIsDefault() != null && hasId(event.getIsDefault().value())) {
				entity.setIsDefault(event.getIsDefault().value());
			}

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}

			if (entity.getTenant() == null && event.getTenant() != null) {
				log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}",
						event.getTenant().value());
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
