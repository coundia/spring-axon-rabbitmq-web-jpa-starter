package com.groupe2cs.bizyhub.sync.infrastructure.entity;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import java.time.*;
import java.util.*;

import com.groupe2cs.bizyhub.shared.infrastructure.audit.AbstractAuditableEntity;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.AuditListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditListener.class)
@Table(name = "change_log")
public class ChangeLog   extends AbstractAuditableEntity  {

	@Id
	private String id;


	@Column(nullable = false, 
		unique = false

	)

	private String entityTable ;

	@Column(nullable = false, 
		unique = false

	)

	private String entityId ;

	@Column(nullable = true, 
		unique = false

	)

	private String remoteId ;

	@Column(nullable = true, 
		unique = false

	)

	private String operation ;

	@Column(nullable = true, 		columnDefinition = "Text",
		unique = false

	)

	private String payload ;

	@Column(nullable = true, 
		unique = false

	)

	private String status ;

	@Column(nullable = true, 
		unique = false

	)
	@Builder.Default
	private java.time.Instant syncAt  = java.time.Instant.now() ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private Integer attempts  = 0 ;

	@Column(nullable = true, 
		unique = false

	)

	private String error ;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;
	public ChangeLog(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "ChangeLog{" +
		"id='" + id + '\'' +
			", entityTable=" + entityTable +
			", entityId=" + entityId +
			", remoteId=" + remoteId +
			", operation=" + operation +
			", payload=" + payload +
			", status=" + status +
			", syncAt=" + syncAt +
			", attempts=" + attempts +
			", error=" + error +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
