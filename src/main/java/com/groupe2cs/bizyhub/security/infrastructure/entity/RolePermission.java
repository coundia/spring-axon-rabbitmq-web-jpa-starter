package com.groupe2cs.bizyhub.security.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "role_permissions")
public class RolePermission {

	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;
	@ManyToOne
	@JoinColumn(name = "permission_id", nullable = false)
	private Permission permission;

	public RolePermission(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RolePermission{" +
				"id='" + id + '\'' +
				", role=" + role +
				", permission=" + permission +
				'}';
	}
}
