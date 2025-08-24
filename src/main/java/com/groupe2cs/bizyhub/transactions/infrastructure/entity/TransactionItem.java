package com.groupe2cs.bizyhub.transactions.infrastructure.entity;

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
@Table(name = "transaction_item")
public class TransactionItem   extends AbstractAuditableEntity  {

	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "transaction_id", nullable = false)
	private com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction transaction;
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = true)
	private com.groupe2cs.bizyhub.products.infrastructure.entity.Product product;

	@Column(nullable = true, 
		unique = false

	)

	private String label ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private Integer quantity  = 1 ;
	@ManyToOne
	@JoinColumn(name = "unit_id", nullable = true)
	private com.groupe2cs.bizyhub.units.infrastructure.entity.Unit unit;

	@Column(nullable = true, 
		unique = false

	)

	private String remoteId ;

	@Column(nullable = true, 
		unique = false

	)
	@Builder.Default
	private java.time.Instant syncAt  = java.time.Instant.now() ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private Double unitPrice  = 0.0 ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private Double total  = 0.0 ;

	@Column(nullable = true, 
		unique = false

	)

	private String notes ;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;
	public TransactionItem(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "TransactionItem{" +
		"id='" + id + '\'' +
			", transaction=" + transaction +
			", product=" + product +
			", label=" + label +
			", quantity=" + quantity +
			", unit=" + unit +
			", remoteId=" + remoteId +
			", syncAt=" + syncAt +
			", unitPrice=" + unitPrice +
			", total=" + total +
			", notes=" + notes +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
