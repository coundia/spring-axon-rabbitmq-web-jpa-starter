package com.groupe2cs.bizyhub.settings.infrastructure.entity;

import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
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
@Table(name = "settings")
public class Setting   extends AbstractAuditableEntity  {

	@Id
	private String id;


	@Column(nullable = false, 
		unique = true  ,
		length = 250
	)

	private String name ;

	@Column(nullable = false, 
		unique = true  ,
		length = 250
	)

	private String reference ;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)
	@Builder.Default
	private java.time.Instant updatedAt  = java.time.Instant.now() ;

	@Column(nullable = false, 
		unique = false  ,
		length = 250
	)

	private String stringValue ;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)

	private String descriptions ;

	@Column(nullable = false, 
		unique = false  ,
		length = 250
	)
	@Builder.Default
	private Boolean isActive  = true ;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private CustomUser createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;
	public Setting(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "Setting{" +
		"id='" + id + '\'' +
			", name=" + name +
			", reference=" + reference +
			", updatedAt=" + updatedAt +
			", stringValue=" + stringValue +
			", descriptions=" + descriptions +
			", isActive=" + isActive +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
