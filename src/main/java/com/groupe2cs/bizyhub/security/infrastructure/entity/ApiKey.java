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
@Table(name = "api_keys")
public class ApiKey {

	@Id
	private String id;

	@Column(nullable = false, unique = true)
	private String key;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false, unique = false)
	private java.time.Instant createdAt;
	@Column(nullable = false, unique = false)
	private java.time.Instant expiration;
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
	'}';
	}
}
