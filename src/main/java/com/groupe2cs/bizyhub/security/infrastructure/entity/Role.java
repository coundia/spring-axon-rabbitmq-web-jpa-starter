package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.infrastructure.audit.AbstractAuditableEntity;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.AuditListener;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
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
@EntityListeners(AuditListener.class)
@Table(name = "")
public class Role extends AbstractAuditableEntity {

	@Id
	private String id;


	@Column(nullable = false,
			unique = true)
	private String name;
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<RolePermission> rolePermissions = new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private CustomUser createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public Role(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Role{" +
				"id='" + id + '\'' +
				", name=" + name +
				", rolePermissions=" + rolePermissions +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
