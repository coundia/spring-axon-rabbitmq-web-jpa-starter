package com.groupe2cs.bizyhub.shared.infrastructure.audit;


import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.PreRemove;
import java.time.Instant;

public class AuditListener {

	@PrePersist
	public void setAuditFields(Object entity) {
		if (!(entity instanceof Auditable auditable)) return;

		auditable.setCreatedAtAudit(Instant.now());
		auditable.setStatusAudit("ACTIVE");
		auditable.setDeletedAudit(false);
		auditable.setVersionAudit("1");
		auditable.setSourceSystemAudit("SYSTEM");

		auditable.setUpdatedAtAudit(null);
		auditable.setUpdatedByAudit(null);
		auditable.setDeletedAtAudit(null);
		auditable.setDeletedByAudit(null);
	}

	@PreUpdate
	public void updateAuditFields(Object entity) {
		if (!(entity instanceof Auditable auditable)) return;

		auditable.setUpdatedAtAudit(Instant.now());
	}

	@PreRemove
	public void deleteAuditFields(Object entity) {
		if (!(entity instanceof Auditable auditable)) return;

		auditable.setDeletedAtAudit(Instant.now());
		auditable.setDeletedAudit(true);
	}
}
