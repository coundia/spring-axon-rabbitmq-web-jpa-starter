package com.groupe2cs.bizyhub.shared.infrastructure.audit;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractAuditableEntity implements Auditable {

	@Column(nullable = true)
	private String updatedByAudit;

	@Column(nullable = true)
	private String deletedByAudit;

	@Column(nullable = true)
	private Instant createdAtAudit;

	@Column(nullable = true)
	private Instant updatedAtAudit;

	@Column(nullable = true)
	private Instant deletedAtAudit;

	@Column(nullable = true)
	private String statusAudit;

	@Column(nullable = true)
	private String versionAudit;

	@Column(nullable = true)
	private String sourceSystemAudit;

	@Column(nullable = true)
	private Boolean deletedAudit;
}
