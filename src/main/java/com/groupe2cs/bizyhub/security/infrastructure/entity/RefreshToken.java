package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

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
@Table(name = "refresh_tokens")
public class RefreshToken  {

	@Id
	private String id;

	@Column(nullable = false, unique = true  , length = 768  )
	private String token;
	@Column(nullable = false, unique = true    )
	private String username;
	@Column(nullable = false, unique = false    )
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
