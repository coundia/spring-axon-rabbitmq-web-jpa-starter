package com.groupe2cs.bizyhub.security.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role {

	@Id
	private String id;

	@Column(nullable = false, unique = true)
	private String name;
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RolePermission> rolePermissions = new HashSet<>();

	public Role(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Role{" +
				"id='" + id + '\'' +
				", name=" + name +
				", rolePermissions=" + rolePermissions +
				'}';
	}
}
