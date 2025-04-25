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

import java.util.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "permissions")
public class Permission  {

	@Id
	private String id;

	@Column(nullable = false, unique = true    )
	private String name;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
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
