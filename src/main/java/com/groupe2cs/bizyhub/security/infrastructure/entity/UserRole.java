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
@Table(name = "user_roles")
public class UserRole extends AbstractAuditableEntity {

	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public UserRole(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserRole{" +
				"id='" + id + '\'' +
				", user=" + user +
				", role=" + role +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
