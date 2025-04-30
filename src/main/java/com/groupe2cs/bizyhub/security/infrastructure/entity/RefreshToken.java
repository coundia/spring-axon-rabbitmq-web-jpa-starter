package com.groupe2cs.bizyhub.security.infrastructure.entity;

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
@Table(name = "refresh_tokens")
public class RefreshToken extends AbstractAuditableEntity {

	@Id
	private String id;


	@Column(nullable = false, columnDefinition = "TEXT",
			unique = false
	)

	private String token;

	@Column(nullable = false,
			unique = false
	)

	private String username;

	@Column(nullable = false,
			unique = false
	)

	private java.time.Instant expiration;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private CustomUser createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public RefreshToken(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RefreshToken{" +
				"id='" + id + '\'' +
				", token=" + token +
				", username=" + username +
				", expiration=" + expiration +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
