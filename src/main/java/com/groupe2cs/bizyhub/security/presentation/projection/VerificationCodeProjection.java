package com.groupe2cs.bizyhub.security.presentation.projection;

import com.groupe2cs.bizyhub.security.domain.event.VerificationCodeCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.VerificationCodeDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.VerificationCodeUpdatedEvent;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.entity.VerificationCode;
import com.groupe2cs.bizyhub.security.infrastructure.repository.VerificationCodeRepository;
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
@ProcessingGroup("VerificationCode")
public class VerificationCodeProjection {

	private final VerificationCodeRepository repository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(VerificationCodeCreatedEvent event) {
		try {
			VerificationCode entity = VerificationCode.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getNotes() != null && hasId(event.getNotes().value())) {
				entity.setNotes(event.getNotes().value());
			}
			if (event.getToken() != null && hasId(event.getToken().value())) {
				entity.setToken(event.getToken().value());
			}
			if (event.getUsername() != null && hasId(event.getUsername().value())) {
				entity.setUsername(event.getUsername().value());
			}
			if (event.getPhone() != null && hasId(event.getPhone().value())) {
				entity.setPhone(event.getPhone().value());
			}
			if (event.getEmail() != null && hasId(event.getEmail().value())) {
				entity.setEmail(event.getEmail().value());
			}
			if (event.getCode() != null && hasId(event.getCode().value())) {
				entity.setCode(event.getCode().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getSource() != null && hasId(event.getSource().value())) {
				entity.setSource(event.getSource().value());
			}
			if (event.getExpiration() != null && hasId(event.getExpiration().value())) {
				entity.setExpiration(event.getExpiration().value());
			}


			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}


			repository.save(entity);


			log.info("VerificationCode inserted: {}", entity);

		} catch (Exception e) {
			log.error("Error saving VerificationCode: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(VerificationCodeUpdatedEvent event) {
		try {
			VerificationCode entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("VerificationCode not found"));


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getNotes() != null && hasId(event.getNotes().value())) {
				entity.setNotes(event.getNotes().value());
			}
			if (event.getToken() != null && hasId(event.getToken().value())) {
				entity.setToken(event.getToken().value());
			}
			if (event.getUsername() != null && hasId(event.getUsername().value())) {
				entity.setUsername(event.getUsername().value());
			}
			if (event.getPhone() != null && hasId(event.getPhone().value())) {
				entity.setPhone(event.getPhone().value());
			}
			if (event.getEmail() != null && hasId(event.getEmail().value())) {
				entity.setEmail(event.getEmail().value());
			}
			if (event.getCode() != null && hasId(event.getCode().value())) {
				entity.setCode(event.getCode().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getSource() != null && hasId(event.getSource().value())) {
				entity.setSource(event.getSource().value());
			}
			if (event.getExpiration() != null && hasId(event.getExpiration().value())) {
				entity.setExpiration(event.getExpiration().value());
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


			log.info("VerificationCode updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating VerificationCode: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(VerificationCodeDeletedEvent event) {
		try {


			repository.deleteById(event.getId().value());
			log.info("VerificationCode deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting VerificationCode: {}", e.getMessage(), e);
			throw e;
		}
	}
}
