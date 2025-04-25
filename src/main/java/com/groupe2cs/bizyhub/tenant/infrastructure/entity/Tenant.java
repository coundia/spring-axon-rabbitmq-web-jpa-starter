package com.groupe2cs.bizyhub.tenant.infrastructure.entity;

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
@Table(name = "tenants")
public class Tenant  {

	@Id
	private String id;

	@Column(nullable = false, unique = true    )
	private String name;
	@Column(nullable = true, unique = false  , length = 2048  )
	private String description;
	@Column(nullable = true, unique = false    )
	private String domain;
	@Column(nullable = true, unique = false    )
	private String language;
	@Column(nullable = true, unique = false    )
	private Boolean active;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	public Tenant(String id) {
		this.id = id;
	}

	@Override
 	public String toString() {
		return "Tenant{" +
		"id='" + id + '\'' +
			", name=" + name +
			", description=" + description +
			", domain=" + domain +
			", language=" + language +
			", active=" + active +
			", createdBy=" + createdBy +
		'}';
	}
}
