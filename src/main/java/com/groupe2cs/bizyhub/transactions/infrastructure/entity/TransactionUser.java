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
@Table(name = "transaction_users")
public class TransactionUser extends AbstractAuditableEntity {

	@Id
	private String id;


	@Column(nullable = false,
			unique = false

	)

	private String name;

	@Column(nullable = true,
			unique = false

	)

	private String remoteId;

	@Column(nullable = true,
			unique = false

	)

	private String localId;

	@Column(nullable = true,
			unique = false

	)

	private String transaction;

	@Column(nullable = true,
			unique = false

	)

	private String user;

	@Column(nullable = true,
			unique = false

	)
	@Builder.Default
	private java.time.Instant syncAt = java.time.Instant.now();

	@Column(nullable = true,
			unique = false

	)

	private String username;

	@Column(nullable = true,
			unique = false

	)

	private String details;

	@Column(nullable = true,
			unique = false

	)

	private Boolean isActive;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public TransactionUser(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TransactionUser{" +
				"id='" + id + '\'' +
				", name=" + name +
				", remoteId=" + remoteId +
				", localId=" + localId +
				", transaction=" + transaction +
				", user=" + user +
				", syncAt=" + syncAt +
				", username=" + username +
				", details=" + details +
				", isActive=" + isActive +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
