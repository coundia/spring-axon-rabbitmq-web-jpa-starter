package com.groupe2cs.bizyhub.debts.infrastructure.entity;

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
@Table(name = "debt")
public class Debt   extends AbstractAuditableEntity  {

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

	private String notes ;

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

	private java.time.Instant dueDate ;

	@Column(nullable = true, 		columnDefinition = "Text",
		unique = false

	)

	private String statuses ;

	@Column(nullable = true, 
		unique = false

	)
	@Builder.Default
	private java.time.Instant syncAt  = java.time.Instant.now() ;

	@Column(nullable = true, 
		unique = false

	)

	private String customer ;

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
	public Debt(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "Debt{" +
		"id='" + id + '\'' +
			", remoteId=" + remoteId +
			", localId=" + localId +
			", code=" + code +
			", notes=" + notes +
			", balance=" + balance +
			", balanceDebt=" + balanceDebt +
			", dueDate=" + dueDate +
			", statuses=" + statuses +
			", syncAt=" + syncAt +
			", customer=" + customer +
			", isActive=" + isActive +
			", createdBy=" + createdBy +
			", tenant=" + tenant +
		'}';
	}
}
