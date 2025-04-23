package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import java.util.*;

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
