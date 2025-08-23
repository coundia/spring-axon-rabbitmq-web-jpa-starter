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
@Table(name = "transaction_entry")
public class TransactionEntry   extends AbstractAuditableEntity  {

	@Id
	private String id;


	@Column(nullable = true, 
		unique = false

	)

	private String remoteId ;

	@Column(nullable = true, 
		unique = false

	)

	private String code ;

	@Column(nullable = true, 
		unique = false

	)

	private String description ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private Double amount  = 0.0 ;

	@Column(nullable = false, 
		unique = false

	)
	@Builder.Default
	private String typeEntry  = "DEBIT" ;

	@Column(nullable = true, 
		unique = false

	)
	@Builder.Default
	private java.time.Instant dateTransaction  = java.time.Instant.now() ;

	@Column(nullable = true, 
		unique = false

	)

	private String status ;

	@Column(nullable = true, 
		unique = false

	)

	private String entityName ;

	@Column(nullable = true, 
		unique = false

	)

	private String entityId ;
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = true)
	private com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account account;

	@Column(nullable = true, 
		unique = false

	)
	@Builder.Default
	private java.time.Instant syncAt  = java.time.Instant.now() ;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = true)
	private com.groupe2cs.bizyhub.categories.infrastructure.entity.Category category;
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = true)
	private com.groupe2cs.bizyhub.companies.infrastructure.entity.Company company;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = true)
	private com.groupe2cs.bizyhub.customers.infrastructure.entity.Customer customer;
	@ManyToOne
	@JoinColumn(name = "debt_id", nullable = true)
	private com.groupe2cs.bizyhub.debts.infrastructure.entity.Debt debt;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;
	public TransactionEntry(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "TransactionEntry{" +
		"id='" + id + '\'' +
			", remoteId=" + remoteId +
			", code=" + code +
			", description=" + description +
			", amount=" + amount +
			", typeEntry=" + typeEntry +
			", dateTransaction=" + dateTransaction +
			", status=" + status +
			", entityName=" + entityName +
			", entityId=" + entityId +
			", account=" + account +
			", syncAt=" + syncAt +
			", category=" + category +
			", company=" + company +
			", customer=" + customer +
			", debt=" + debt +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
