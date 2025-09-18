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
@Table(name = "product")
public class Product   extends AbstractAuditableEntity  {

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

	@Column(nullable = false, 
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

	private String status ;

	@Column(nullable = true, 
		unique = false

	)

	private Boolean isPublic ;

	@Column(nullable = true, 
		unique = false

	)

	private Boolean hasSold ;

	@Column(nullable = true, 
		unique = false

	)

	private Boolean hasPrice ;

	@Column(nullable = true, 
		unique = false

	)

	private String level ;

	@Column(nullable = true, 
		unique = false

	)

	private Integer quantity ;

	@Column(nullable = true, 
		unique = false

	)

	private String barcode ;

	@Column(nullable = true, 
		unique = false

	)

	private String company ;

	@Column(nullable = true, 
		unique = false

	)

	private String unit ;

	@Column(nullable = true, 
		unique = false

	)
	@Builder.Default
	private java.time.Instant syncAt  = java.time.Instant.now() ;

	@Column(nullable = true, 
		unique = false

	)

	private String category ;

	@Column(nullable = true, 
		unique = false

	)

	private String account ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private Double defaultPrice  = 0.0 ;

	@Column(nullable = true, 		columnDefinition = "Text",
		unique = false

	)

	private String statuses ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private Double purchasePrice  = 0.0 ;
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
			", remoteId=" + remoteId +
			", localId=" + localId +
			", code=" + code +
			", name=" + name +
			", description=" + description +
			", status=" + status +
			", isPublic=" + isPublic +
			", hasSold=" + hasSold +
			", hasPrice=" + hasPrice +
			", level=" + level +
			", quantity=" + quantity +
			", barcode=" + barcode +
			", company=" + company +
			", unit=" + unit +
			", syncAt=" + syncAt +
			", category=" + category +
			", account=" + account +
			", defaultPrice=" + defaultPrice +
			", statuses=" + statuses +
			", purchasePrice=" + purchasePrice +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
