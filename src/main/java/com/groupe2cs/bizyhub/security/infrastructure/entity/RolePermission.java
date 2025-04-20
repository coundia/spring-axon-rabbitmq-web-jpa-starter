package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
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
