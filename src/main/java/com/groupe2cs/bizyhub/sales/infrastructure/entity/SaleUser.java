package com.groupe2cs.bizyhub.sales.infrastructure.entity;

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
@Table(name = "sale_users")
public class SaleUser   extends AbstractAuditableEntity  {

	@Id
	private String id;


	@Column(nullable = false, 
		unique = false  ,
		length = 250
	)

	private String name ;
	@ManyToOne
	@JoinColumn(name = "sales_id", nullable = true)
	private com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale sales;
	@ManyToOne
	@JoinColumn(name = "users_id", nullable = true)
	private com.groupe2cs.bizyhub.security.infrastructure.entity.User users;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)

	private String username ;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)

	private String details ;

	@Column(nullable = false, 
		unique = false  ,
		length = 250
	)
	@Builder.Default
	private Boolean isActive  = true ;

	@Column(nullable = true, 
		unique = false  
	)
	@Builder.Default
	private java.time.Instant updatedAt  = java.time.Instant.now() ;

	@Column(nullable = true, 
		unique = false  
	)

	private String reference ;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;
	public SaleUser(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "SaleUser{" +
		"id='" + id + '\'' +
			", name=" + name +
			", sales=" + sales +
			", users=" + users +
			", username=" + username +
			", details=" + details +
			", isActive=" + isActive +
			", updatedAt=" + updatedAt +
			", reference=" + reference +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
