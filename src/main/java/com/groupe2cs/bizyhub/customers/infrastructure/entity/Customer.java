package com.groupe2cs.bizyhub.customers.infrastructure.entity;

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
@Table(name = "customer")
public class Customer   extends AbstractAuditableEntity  {

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

	@Column(nullable = true, 
		unique = false

	)

	private String code ;

	@Column(nullable = true, 
		unique = false

	)

	private String firstName ;

	@Column(nullable = true, 
		unique = false

	)

	private String lastName ;

	@Column(nullable = true, 
		unique = false

	)

	private String fullName ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private Double balance  = 0.0 ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private Double balanceDebt  = 0.0 ;

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

	private String notes ;

	@Column(nullable = true, 
		unique = false

	)

	private String status ;
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = true)
	private com.groupe2cs.bizyhub.companies.infrastructure.entity.Company company;

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
	@Builder.Default
	private java.time.Instant syncAt  = java.time.Instant.now() ;

	@Column(nullable = true, 
		unique = false

	)

	private Boolean isActive ;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;
	public Customer(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "Customer{" +
		"id='" + id + '\'' +
			", remoteId=" + remoteId +
			", localId=" + localId +
			", code=" + code +
			", firstName=" + firstName +
			", lastName=" + lastName +
			", fullName=" + fullName +
			", balance=" + balance +
			", balanceDebt=" + balanceDebt +
			", phone=" + phone +
			", email=" + email +
			", notes=" + notes +
			", status=" + status +
			", company=" + company +
			", addressLine1=" + addressLine1 +
			", addressLine2=" + addressLine2 +
			", city=" + city +
			", region=" + region +
			", country=" + country +
			", postalCode=" + postalCode +
			", syncAt=" + syncAt +
			", isActive=" + isActive +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
