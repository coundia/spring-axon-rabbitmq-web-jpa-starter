package com.groupe2cs.bizyhub.accounts.presentation.projection;

import com.groupe2cs.bizyhub.accounts.domain.event.AccountCreatedEvent;
import com.groupe2cs.bizyhub.accounts.domain.event.AccountDeletedEvent;
import com.groupe2cs.bizyhub.accounts.domain.event.AccountUpdatedEvent;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository;
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
@ProcessingGroup("Account")
public class AccountProjection {

	private final AccountRepository repository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(AccountCreatedEvent event) {
		try {
			Account entity = Account.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getCode() != null && hasId(event.getCode().value())) {
				entity.setCode(event.getCode().value());
			}
			if (event.getName() != null && hasId(event.getName().value())) {
				entity.setName(event.getName().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getCurrency() != null && hasId(event.getCurrency().value())) {
				entity.setCurrency(event.getCurrency().value());
			}
			if (event.getTypeAccount() != null && hasId(event.getTypeAccount().value())) {
				entity.setTypeAccount(event.getTypeAccount().value());
			}
			if (event.getBalance() != null && hasId(event.getBalance().value())) {
				entity.setBalance(event.getBalance().value());
			}
			if (event.getBalancePrev() != null && hasId(event.getBalancePrev().value())) {
				entity.setBalancePrev(event.getBalancePrev().value());
			}
			if (event.getBalanceBlocked() != null && hasId(event.getBalanceBlocked().value())) {
				entity.setBalanceBlocked(event.getBalanceBlocked().value());
			}
			if (event.getBalanceInit() != null && hasId(event.getBalanceInit().value())) {
				entity.setBalanceInit(event.getBalanceInit().value());
			}
			if (event.getBalanceGoal() != null && hasId(event.getBalanceGoal().value())) {
				entity.setBalanceGoal(event.getBalanceGoal().value());
			}
			if (event.getBalanceLimit() != null && hasId(event.getBalanceLimit().value())) {
				entity.setBalanceLimit(event.getBalanceLimit().value());
			}
			if (event.getDescription() != null && hasId(event.getDescription().value())) {
				entity.setDescription(event.getDescription().value());
			}
			if (event.getIsActive() != null && hasId(event.getIsActive().value())) {
				entity.setIsActive(event.getIsActive().value());
			}
			if (event.getIsDefault() != null && hasId(event.getIsDefault().value())) {
				entity.setIsDefault(event.getIsDefault().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
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


			log.info("Account inserted: {}", entity);

		} catch (Exception e) {
			log.error("Error saving Account: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(AccountUpdatedEvent event) {
		try {
			Account entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("Account not found"));


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getCode() != null && hasId(event.getCode().value())) {
				entity.setCode(event.getCode().value());
			}
			if (event.getName() != null && hasId(event.getName().value())) {
				entity.setName(event.getName().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getCurrency() != null && hasId(event.getCurrency().value())) {
				entity.setCurrency(event.getCurrency().value());
			}
			if (event.getTypeAccount() != null && hasId(event.getTypeAccount().value())) {
				entity.setTypeAccount(event.getTypeAccount().value());
			}
			if (event.getBalance() != null && hasId(event.getBalance().value())) {
				entity.setBalance(event.getBalance().value());
			}
			if (event.getBalancePrev() != null && hasId(event.getBalancePrev().value())) {
				entity.setBalancePrev(event.getBalancePrev().value());
			}
			if (event.getBalanceBlocked() != null && hasId(event.getBalanceBlocked().value())) {
				entity.setBalanceBlocked(event.getBalanceBlocked().value());
			}
			if (event.getBalanceInit() != null && hasId(event.getBalanceInit().value())) {
				entity.setBalanceInit(event.getBalanceInit().value());
			}
			if (event.getBalanceGoal() != null && hasId(event.getBalanceGoal().value())) {
				entity.setBalanceGoal(event.getBalanceGoal().value());
			}
			if (event.getBalanceLimit() != null && hasId(event.getBalanceLimit().value())) {
				entity.setBalanceLimit(event.getBalanceLimit().value());
			}
			if (event.getDescription() != null && hasId(event.getDescription().value())) {
				entity.setDescription(event.getDescription().value());
			}
			if (event.getIsActive() != null && hasId(event.getIsActive().value())) {
				entity.setIsActive(event.getIsActive().value());
			}
			if (event.getIsDefault() != null && hasId(event.getIsDefault().value())) {
				entity.setIsDefault(event.getIsDefault().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
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


			log.info("Account updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating Account: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(AccountDeletedEvent event) {
		try {


			repository.deleteById(event.getId().value());
			log.info("Account deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting Account: {}", e.getMessage(), e);
			throw e;
		}
	}
}
