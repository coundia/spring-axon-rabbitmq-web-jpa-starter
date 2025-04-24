package com.groupe2cs.bizyhub.security.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "refresh_tokens")
public class RefreshToken {

	@Id
	private String id;

	@Column(nullable = false, unique = true, length = 2048)
	private String token;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false, unique = false)
	private java.time.Instant expiration;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;

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
				'}';
	}
}
