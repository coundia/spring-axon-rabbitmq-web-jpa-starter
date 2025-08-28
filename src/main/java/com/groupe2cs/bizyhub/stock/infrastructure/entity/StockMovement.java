package com.groupe2cs.bizyhub.stock.infrastructure.entity;

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
@Table(name = "stock_movement")
public class StockMovement   extends AbstractAuditableEntity  {

	@Id
	private String id;


	@Column(nullable = false, 
		unique = false

	)

	private String typeStockMovement ;

	@Column(nullable = false, 
		unique = false

	)

	private Integer quantity ;

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

	private String account ;

	@Column(nullable = true, 
		unique = false

	)

	private String company ;

	@Column(nullable = true, 
		unique = false

	)
	@Builder.Default
	private java.time.Instant syncAt  = java.time.Instant.now() ;

	@Column(nullable = true, 
		unique = false

	)

	private String productVariant ;

	@Column(nullable = true, 
		unique = false

	)

	private String orderLineId ;

	@Column(nullable = true, 
		unique = false

	)

	private String discriminator ;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;
	public StockMovement(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "StockMovement{" +
		"id='" + id + '\'' +
			", typeStockMovement=" + typeStockMovement +
			", quantity=" + quantity +
			", remoteId=" + remoteId +
			", localId=" + localId +
			", account=" + account +
			", company=" + company +
			", syncAt=" + syncAt +
			", productVariant=" + productVariant +
			", orderLineId=" + orderLineId +
			", discriminator=" + discriminator +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
