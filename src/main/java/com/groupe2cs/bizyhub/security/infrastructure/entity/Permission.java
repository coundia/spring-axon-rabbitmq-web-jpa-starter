package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "permissions")
public class Permission {

	@Id
	private String id;

	@Column(nullable = false, unique = true)
	private String name;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private CustomUser createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public Permission(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Permission{" +
				"id='" + id + '\'' +
				", name=" + name +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
