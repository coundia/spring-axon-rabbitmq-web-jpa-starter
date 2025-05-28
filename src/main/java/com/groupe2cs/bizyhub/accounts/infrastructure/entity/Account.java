package com.groupe2cs.bizyhub.accounts.infrastructure.entity;

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
@Table(name = "accounts")
public class Account   extends AbstractAuditableEntity  {

	@Id
	private String id;


	@Column(nullable = false, 
		unique = false

	)

	private String name ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private String currency  = "XOF" ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private Double currentBalance  = 0.0 ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private Double previousBalance  = 0.0 ;

	@Column(nullable = true, 
		unique = false

	)

	private String details ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private Boolean isActive  = true ;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;
	public Account(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "Account{" +
		"id='" + id + '\'' +
			", name=" + name +
			", currency=" + currency +
			", currentBalance=" + currentBalance +
			", previousBalance=" + previousBalance +
			", details=" + details +
			", isActive=" + isActive +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
