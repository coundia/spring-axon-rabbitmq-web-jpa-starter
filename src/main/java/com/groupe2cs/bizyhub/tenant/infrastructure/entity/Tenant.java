package com.groupe2cs.bizyhub.tenant.infrastructure.entity;

import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tenants")
public class Tenant {

	@Id
	private String id;

	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = true, unique = false, length = 768)
	private String description;
	@Column(nullable = true, unique = false)
	private String domain;
	@Column(nullable = true, unique = false)
	private String language;
	@Column(nullable = true, unique = false)
	private Boolean active;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private CustomUser createdBy;

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
