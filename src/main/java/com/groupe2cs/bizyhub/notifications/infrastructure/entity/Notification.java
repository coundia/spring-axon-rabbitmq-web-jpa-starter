package com.groupe2cs.bizyhub.notifications.infrastructure.entity;

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
@Table(name = "notifications")
public class Notification extends AbstractAuditableEntity {

	@Id
	private String id;


	@Column(nullable = true,
			unique = false

	)

	private String deviceToken;

	@Column(nullable = false, columnDefinition = "Text",
			unique = false

	)

	private String title;

	@Column(nullable = true, columnDefinition = "Text",
			unique = false

	)

	private String message;

	@Column(nullable = true,
			unique = false

	)

	private String status;

	@Column(nullable = true,
			unique = false

	)

	private String reserved;

	@Column(nullable = true,
			unique = false

	)

	private String errorMessage;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public Notification(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Notification{" +
				"id='" + id + '\'' +
				", deviceToken=" + deviceToken +
				", title=" + title +
				", message=" + message +
				", status=" + status +
				", reserved=" + reserved +
				", errorMessage=" + errorMessage +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
