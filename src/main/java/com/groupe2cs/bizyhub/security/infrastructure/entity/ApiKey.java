package com.groupe2cs.bizyhub.security.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "api_keys")
public class ApiKey {

	@Id
	private String id;

	@Column(nullable = false, unique = true, length = 2048)
	private String key;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false, unique = false)
	private java.time.Instant createdAt;
	@Column(nullable = false, unique = false)
	private java.time.Instant expiration;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;

	public ApiKey(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ApiKey{" +
				"id='" + id + '\'' +
				", key=" + key +
				", username=" + username +
				", createdAt=" + createdAt +
				", expiration=" + expiration +
				", createdBy=" + createdBy +
				'}';
	}
}
