package com.groupe2cs.bizyhub.settings.infrastructure.entity;

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
@Table(name = "settings")
public class Setting extends AbstractAuditableEntity {

	@Id
	private String id;


	@Column(nullable = false,
			unique = false

	)

	private String name;

	@Column(nullable = false,
			unique = false

	)

	private String value;

	@Column(nullable = false,
			unique = false

	)

	private String locale;

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

	private String account;

	@Column(nullable = true,
			unique = false

	)

	private String details;

	@Column(nullable = true,
			unique = false

	)
	@Builder.Default
	private java.time.Instant syncAt = java.time.Instant.now();

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

	public Setting(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Setting{" +
				"id='" + id + '\'' +
				", name=" + name +
				", value=" + value +
				", locale=" + locale +
				", remoteId=" + remoteId +
				", localId=" + localId +
				", account=" + account +
				", details=" + details +
				", syncAt=" + syncAt +
				", isActive=" + isActive +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
