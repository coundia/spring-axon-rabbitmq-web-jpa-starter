package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import java.time.*;
import java.util.*;

import com.groupe2cs.bizyhub.shared.infrastructure.audit.AbstractAuditableEntity;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.AuditListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditListener.class)
@Table(name = "verification_codes")
public class VerificationCode extends AbstractAuditableEntity {

	@Id
	private String id;


	@Column(nullable = true, columnDefinition = "TEXT",
			unique = false

	)

	private String notes;

	@Column(nullable = true, columnDefinition = "TEXT",
			unique = false

	)

	private String token;

	@Column(nullable = true,
			unique = false

	)

	private String username;

	@Column(nullable = true,
			unique = false

	)

	private String phone;

	@Column(nullable = true,
			unique = false

	)

	private String email;

	@Column(nullable = true,
			unique = false

	)

	private String code;

	@Column(nullable = true,
			unique = false

	)

	private String status;

	@Column(nullable = true,
			unique = false

	)

	private String source;

	@Column(nullable = true,
			unique = false

	)

	private java.time.Instant expiration;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public VerificationCode(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "VerificationCode{" +
				"id='" + id + '\'' +
				", notes=" + notes +
				", token=" + token +
				", username=" + username +
				", phone=" + phone +
				", email=" + email +
				", code=" + code +
				", status=" + status +
				", source=" + source +
				", expiration=" + expiration +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
