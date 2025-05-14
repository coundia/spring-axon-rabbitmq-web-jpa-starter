package com.groupe2cs.bizyhub.transactions.infrastructure.entity;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.AbstractAuditableEntity;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.AuditListener;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditListener.class)
@Table(name = "transactions")
public class Transaction extends AbstractAuditableEntity {

	@Id
	private String id;


	@Column(nullable = false,
			unique = false,
			length = 250
	)

	private String name;

	@Column(nullable = false,
			unique = false,
			length = 250
	)

	private Double amount;

	@Column(nullable = true,
			unique = false,
			length = 250
	)

	private String details;

	@Column(nullable = false,
			unique = false,
			length = 250
	)
	@Builder.Default
	private Boolean isActive = true;
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = true)
	private com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account account;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = true)
	private com.groupe2cs.bizyhub.categories.infrastructure.entity.Category category;

	@Column(nullable = true,
			unique = false,
			length = 250
	)

	private String typeTransactionRaw;

	@Column(nullable = true,
			unique = false,
			length = 250
	)
	@Builder.Default
	private java.time.Instant dateTransaction = java.time.Instant.now();

	@Column(nullable = true,
			unique = false
	)
	@Builder.Default
	private java.time.Instant updatedAt = java.time.Instant.now();

	@Column(nullable = true,
			unique = false
	)

	private String reference;
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
				", name=" + name +
				", amount=" + amount +
				", details=" + details +
				", isActive=" + isActive +
				", account=" + account +
				", category=" + category +
				", typeTransactionRaw=" + typeTransactionRaw +
				", dateTransaction=" + dateTransaction +
				", updatedAt=" + updatedAt +
				", reference=" + reference +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
