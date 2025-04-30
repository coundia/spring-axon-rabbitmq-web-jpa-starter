package com.groupe2cs.bizyhub.balances.infrastructure.entity;

import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.AbstractAuditableEntity;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.AuditListener;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditListener.class)
@Table(name = "balances")
public class Balance extends AbstractAuditableEntity {

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
	@Builder.Default
	private String currency = "XOF";

	@Column(nullable = false,
			unique = false,
			length = 250
	)
	@Builder.Default
	private Double currentBalance = 0.0;

	@Column(nullable = false,
			unique = false,
			length = 250
	)
	@Builder.Default
	private Double previousBalance = 0.0;

	@Column(nullable = false,
			unique = false,
			length = 250
	)
	@Builder.Default
	private java.time.Instant lastUpdated = Instant.now();

	@Column(nullable = false,
			unique = false,
			length = 250
	)
	@Builder.Default
	private Boolean isDefault = false;

	@Column(nullable = false,
			unique = false,
			length = 250
	)
	@Builder.Default
	private Integer ordre = 0;

	@Column(nullable = false,
			unique = false,
			length = 250
	)
	@Builder.Default
	private Boolean isArchived = false;

	@Column(nullable = false,
			unique = false,
			length = 250
	)
	@Builder.Default
	private Boolean isAllowDebit = true;

	@Column(nullable = false,
			unique = false,
			length = 250
	)
	@Builder.Default
	private Boolean isAllowCredit = true;

	@Column(nullable = false,
			unique = false,
			length = 250
	)
	@Builder.Default
	private Boolean isExcluTotal = false;

	@Column(nullable = false,
			unique = false,
			length = 250
	)
	@Builder.Default
	private Boolean activateNotification = false;

	@Column(nullable = true,
			unique = false,
			length = 250
	)
	@Builder.Default
	private java.time.Instant syncedAt = Instant.now();
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private CustomUser createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public Balance(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Balance{" +
				"id='" + id + '\'' +
				", name=" + name +
				", currency=" + currency +
				", currentBalance=" + currentBalance +
				", previousBalance=" + previousBalance +
				", lastUpdated=" + lastUpdated +
				", isDefault=" + isDefault +
				", ordre=" + ordre +
				", isArchived=" + isArchived +
				", isAllowDebit=" + isAllowDebit +
				", isAllowCredit=" + isAllowCredit +
				", isExcluTotal=" + isExcluTotal +
				", activateNotification=" + activateNotification +
				", syncedAt=" + syncedAt +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
