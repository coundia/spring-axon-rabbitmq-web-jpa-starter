package com.groupe2cs.bizyhub.companies.infrastructure.entity;

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
@Table(name = "company")
public class Company   extends AbstractAuditableEntity  {

	@Id
	private String id;


	@Column(nullable = true, 
		unique = false

	)

	private String remoteId ;

	@Column(nullable = true, 
		unique = false

	)

	private String localId ;

	@Column(nullable = false, 
		unique = false

	)

	private String code ;

	@Column(nullable = true, 
		unique = false

	)

	private String name ;

	@Column(nullable = true, 
		unique = false

	)

	private String description ;

	@Column(nullable = true, 
		unique = false

	)

	private String phone ;

	@Column(nullable = true, 
		unique = false

	)

	private String email ;

	@Column(nullable = true, 
		unique = false

	)

	private String website ;

	@Column(nullable = true, 
		unique = false

	)

	private String taxId ;

	@Column(nullable = true, 
		unique = false

	)

	private String currency ;

	@Column(nullable = true, 
		unique = false

	)

	private String addressLine1 ;

	@Column(nullable = true, 
		unique = false

	)

	private String addressLine2 ;

	@Column(nullable = true, 
		unique = false

	)

	private String city ;

	@Column(nullable = true, 
		unique = false

	)

	private String region ;

	@Column(nullable = true, 
		unique = false

	)

	private String country ;

	@Column(nullable = true, 
		unique = false

	)

	private String postalCode ;

	@Column(nullable = true, 
		unique = false

	)

	private Boolean isActive ;

	@Column(nullable = true, 
		unique = false

	)
	@Builder.Default
	private java.time.Instant syncAt  = java.time.Instant.now() ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private Boolean isDefault  = false ;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;
	public Company(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "Company{" +
		"id='" + id + '\'' +
			", remoteId=" + remoteId +
			", localId=" + localId +
			", code=" + code +
			", name=" + name +
			", description=" + description +
			", phone=" + phone +
			", email=" + email +
			", website=" + website +
			", taxId=" + taxId +
			", currency=" + currency +
			", addressLine1=" + addressLine1 +
			", addressLine2=" + addressLine2 +
			", city=" + city +
			", region=" + region +
			", country=" + country +
			", postalCode=" + postalCode +
			", isActive=" + isActive +
			", syncAt=" + syncAt +
			", isDefault=" + isDefault +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
