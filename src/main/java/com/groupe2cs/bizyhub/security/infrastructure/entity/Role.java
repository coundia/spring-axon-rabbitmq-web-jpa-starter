package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.ArrayList;

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
@Table(name = "roles")
public class Role {

	@Id
	private String id;

	@Column(nullable = false, unique = true)
	private String name;
	@OneToMany(mappedBy = "role",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
