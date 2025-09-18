package com.groupe2cs.bizyhub.customers.presentation.projection;

import com.groupe2cs.bizyhub.customers.domain.event.CustomerCreatedEvent;
import com.groupe2cs.bizyhub.customers.domain.event.CustomerDeletedEvent;
import com.groupe2cs.bizyhub.customers.domain.event.CustomerUpdatedEvent;
import com.groupe2cs.bizyhub.customers.infrastructure.entity.Customer;
import com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AllowReplay(value = false)
@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
@ProcessingGroup("Customer")
public class CustomerProjection {

	private final CustomerRepository repository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(CustomerCreatedEvent event) {
		try {
			Customer entity = Customer.builder().build();
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
			if (event.getFirstName() != null && hasId(event.getFirstName().value())) {
				entity.setFirstName(event.getFirstName().value());
			}
			if (event.getLastName() != null && hasId(event.getLastName().value())) {
				entity.setLastName(event.getLastName().value());
			}
			if (event.getFullName() != null && hasId(event.getFullName().value())) {
				entity.setFullName(event.getFullName().value());
			}
			if (event.getBalance() != null && hasId(event.getBalance().value())) {
				entity.setBalance(event.getBalance().value());
			}
			if (event.getBalanceDebt() != null && hasId(event.getBalanceDebt().value())) {
				entity.setBalanceDebt(event.getBalanceDebt().value());
			}
			if (event.getPhone() != null && hasId(event.getPhone().value())) {
				entity.setPhone(event.getPhone().value());
			}
			if (event.getEmail() != null && hasId(event.getEmail().value())) {
				entity.setEmail(event.getEmail().value());
			}
			if (event.getNotes() != null && hasId(event.getNotes().value())) {
				entity.setNotes(event.getNotes().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getCompany() != null && hasId(event.getCompany().value())) {
				entity.setCompany(event.getCompany().value());
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
			if (event.getPostalCode() != null && hasId(event.getPostalCode().value())) {
				entity.setPostalCode(event.getPostalCode().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getIsActive() != null && hasId(event.getIsActive().value())) {
				entity.setIsActive(event.getIsActive().value());
			}


			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}

			if(event.getRemoteId().value() == null) {
				entity.setRemoteId(event.getId().value());
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
			if (event.getFirstName() != null && hasId(event.getFirstName().value())) {
				entity.setFirstName(event.getFirstName().value());
			}
			if (event.getLastName() != null && hasId(event.getLastName().value())) {
				entity.setLastName(event.getLastName().value());
			}
			if (event.getFullName() != null && hasId(event.getFullName().value())) {
				entity.setFullName(event.getFullName().value());
			}
			if (event.getBalance() != null && hasId(event.getBalance().value())) {
				entity.setBalance(event.getBalance().value());
			}
			if (event.getBalanceDebt() != null && hasId(event.getBalanceDebt().value())) {
				entity.setBalanceDebt(event.getBalanceDebt().value());
			}
			if (event.getPhone() != null && hasId(event.getPhone().value())) {
				entity.setPhone(event.getPhone().value());
			}
			if (event.getEmail() != null && hasId(event.getEmail().value())) {
				entity.setEmail(event.getEmail().value());
			}
			if (event.getNotes() != null && hasId(event.getNotes().value())) {
				entity.setNotes(event.getNotes().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getCompany() != null && hasId(event.getCompany().value())) {
				entity.setCompany(event.getCompany().value());
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
			if (event.getPostalCode() != null && hasId(event.getPostalCode().value())) {
				entity.setPostalCode(event.getPostalCode().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getIsActive() != null && hasId(event.getIsActive().value())) {
				entity.setIsActive(event.getIsActive().value());
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
