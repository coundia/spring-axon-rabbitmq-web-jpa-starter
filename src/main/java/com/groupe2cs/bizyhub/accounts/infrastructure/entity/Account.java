package com.groupe2cs.bizyhub.accounts.infrastructure.entity;

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
@Table(name = "accounts")
public class Account extends AbstractAuditableEntity {

	@Id
	private String id;


	@Column(nullable = true,
			unique = false

	)

	private String code;

	@Column(nullable = true,
			unique = false

	)

	private String name;

	@Column(nullable = true,
			unique = false

	)

	private String status;

	@Column(nullable = false,
			unique = false

	)
	@Builder.Default
	private String currency = "XOF";

	@Column(nullable = true,
			unique = false

	)

	private String typeAccount;

	@Column(nullable = false,
			unique = false

	)
	@Builder.Default
	private Double balance = 0.0;

	@Column(nullable = false,
			unique = false

	)
	@Builder.Default
	private Double balancePrev = 0.0;

	@Column(nullable = false,
			unique = false

	)
	@Builder.Default
	private Double balanceBlocked = 0.0;

	@Column(nullable = false,
			unique = false

	)
	@Builder.Default
	private Double balanceInit = 0.0;

	@Column(nullable = false,
			unique = false

	)
	@Builder.Default
	private Double balanceGoal = 0.0;

	@Column(nullable = false,
			unique = false

	)
	@Builder.Default
	private Double balanceLimit = 0.0;

	@Column(nullable = true,
			unique = false

	)

	private String description;

	@Column(nullable = true,
			unique = false

	)

	private Boolean isActive;

	@Column(nullable = true,
			unique = false

	)

	private Boolean isDefault;

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
	@Builder.Default
	private java.time.Instant syncAt = java.time.Instant.now();
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public Account(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Account{" +
				"id='" + id + '\'' +
				", code=" + code +
				", name=" + name +
				", status=" + status +
				", currency=" + currency +
				", typeAccount=" + typeAccount +
				", balance=" + balance +
				", balancePrev=" + balancePrev +
				", balanceBlocked=" + balanceBlocked +
				", balanceInit=" + balanceInit +
				", balanceGoal=" + balanceGoal +
				", balanceLimit=" + balanceLimit +
				", description=" + description +
				", isActive=" + isActive +
				", isDefault=" + isDefault +
				", remoteId=" + remoteId +
				", localId=" + localId +
				", syncAt=" + syncAt +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
