package com.groupe2cs.bizyhub.message.infrastructure.entity;

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
@Table(name = "messages")
public class Message extends AbstractAuditableEntity {

	@Id
	private String id;


	@Column(nullable = true,
			unique = false

	)

	private String code;

	@Column(nullable = true,
			unique = false

	)

	private String email;

	@Column(nullable = true,
			unique = false

	)

	private String phone;

	@Column(nullable = true,
			unique = false

	)

	private String content;

	@Column(nullable = true,
			unique = false

	)

	private String plateforme;

	@Column(nullable = true,
			unique = false

	)

	private String source;

	@Column(nullable = true,
			unique = false

	)

	private String agent;

	@Column(nullable = true,
			unique = false

	)

	private String status;

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
	private java.time.Instant depotAt = java.time.Instant.now();

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

	public Message(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Message{" +
				"id='" + id + '\'' +
				", code=" + code +
				", email=" + email +
				", phone=" + phone +
				", content=" + content +
				", plateforme=" + plateforme +
				", source=" + source +
				", agent=" + agent +
				", status=" + status +
				", description=" + description +
				", isActive=" + isActive +
				", isDefault=" + isDefault +
				", remoteId=" + remoteId +
				", localId=" + localId +
				", depotAt=" + depotAt +
				", syncAt=" + syncAt +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
