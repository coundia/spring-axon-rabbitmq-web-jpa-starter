package com.groupe2cs.bizyhub.transactions.infrastructure.entity;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.AbstractAuditableEntity;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.AuditListener;
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

	@Column(nullable = true, unique = true, length = 250)
	private String reference;
	@Column(nullable = false, unique = false, length = 250)
	private Double amount;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;

	public Transaction(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"id='" + id + '\'' +
				", reference=" + reference +
				", amount=" + amount +
				", createdBy=" + createdBy +
				'}';
	}
}
