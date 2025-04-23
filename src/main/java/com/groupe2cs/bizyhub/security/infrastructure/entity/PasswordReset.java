package com.groupe2cs.bizyhub.security.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

	@Column(nullable = false, unique = true)
	private String token;
	@Column(nullable = false, unique = false)
	private String username;
	@Column(nullable = false, unique = false)
	private java.time.Instant expiration;

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
				'}';
	}
}
