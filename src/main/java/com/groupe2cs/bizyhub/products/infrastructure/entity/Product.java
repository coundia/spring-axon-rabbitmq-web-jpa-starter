package com.groupe2cs.bizyhub.products.infrastructure.entity;

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
@Table(name = "products")
public class Product   extends AbstractAuditableEntity  {

	@Id
	private String id;


	@Column(nullable = false, 
		unique = true  ,
		length = 250
	)

	private String name ;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)
	@Builder.Default
	private Double price  = 0.0 ;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)
	@Builder.Default
	private String details  = "NA" ;

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
	public Product(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "Product{" +
		"id='" + id + '\'' +
			", name=" + name +
			", price=" + price +
			", details=" + details +
			", isActive=" + isActive +
			", updatedAt=" + updatedAt +
			", reference=" + reference +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
