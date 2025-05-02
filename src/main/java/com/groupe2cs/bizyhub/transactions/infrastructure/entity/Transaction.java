package com.groupe2cs.bizyhub.transactions.infrastructure.entity;

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
@Table(name = "transactions")
public class Transaction   extends AbstractAuditableEntity  {

	@Id
	private String id;


	@Column(nullable = false, 
		unique = false  ,
		length = 250
	)
	@Builder.Default
	private Double amount  = 0.0 ;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)

	private java.time.Instant dateOperation ;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)

	private String description ;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)

	private String reference ;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)
	@Builder.Default
	private Boolean isRecurring  = false ;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)
	@Builder.Default
	private Boolean isExcluToRapport  = false ;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)

	private String status ;
	@ManyToOne
	@JoinColumn(name = "balance_id", nullable = true)
	private com.groupe2cs.bizyhub.balances.infrastructure.entity.Balance balance;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = true)
	private com.groupe2cs.bizyhub.categories.infrastructure.entity.Category category;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)

	private java.time.Instant updatedAt ;

	@Column(nullable = true, 
		unique = false  ,
		length = 250
	)

	private java.time.Instant createdAt ;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private CustomUser createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;
	public Transaction(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "Transaction{" +
		"id='" + id + '\'' +
			", amount=" + amount +
			", dateOperation=" + dateOperation +
			", description=" + description +
			", reference=" + reference +
			", isRecurring=" + isRecurring +
			", isExcluToRapport=" + isExcluToRapport +
			", status=" + status +
			", balance=" + balance +
			", category=" + category +
			", updatedAt=" + updatedAt +
			", createdAt=" + createdAt +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
