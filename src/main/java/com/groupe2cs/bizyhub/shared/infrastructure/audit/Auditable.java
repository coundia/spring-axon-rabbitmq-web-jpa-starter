package com.groupe2cs.bizyhub.shared.infrastructure.audit;


import java.time.Instant;

public interface Auditable {

	void setUpdatedByAudit(String updatedByAudit);
	void setDeletedByAudit(String deletedByAudit);
	void setCreatedAtAudit(Instant createdAtAudit);
	void setUpdatedAtAudit(Instant updatedAtAudit);
	void setDeletedAtAudit(Instant deletedAtAudit);
	void setStatusAudit(String statusAudit);
	void setVersionAudit(String versionAudit);
	void setSourceSystemAudit(String sourceSystemAudit);
	void setDeletedAudit(Boolean deletedAudit);
}
