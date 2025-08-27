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
@Table(name = "transactions")
public class Transaction   extends AbstractAuditableEntity  {

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

	@Column(nullable = true, 
		unique = false

	)

	private String account ;

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

	private String company ;

	@Column(nullable = true, 
		unique = false

	)

	private String customer ;

	@Column(nullable = true, 
		unique = false

	)

	private String debt ;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
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
			", remoteId=" + remoteId +
			", localId=" + localId +
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
