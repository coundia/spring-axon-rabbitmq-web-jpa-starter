package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "password_resets")
public class PasswordReset {

	@Id
	private String id;

	@Column(nullable = false, unique = true, length = 768)
	private String token;
	@Column(nullable = false, unique = false)
	private String username;
	@Column(nullable = false, unique = false)
	private java.time.Instant expiration;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private CustomUser createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public PasswordReset(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PasswordReset{" +
				"id='" + id + '\'' +
				", token=" + token +
				", username=" + username +
				", expiration=" + expiration +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
