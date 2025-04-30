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
@Table(name = "custom_users")
public class CustomUser extends AbstractAuditableEntity {

	@Id
	private String id;


	@Column(nullable = false,
			unique = false
	)

	private String username;

	@Column(nullable = false,
			unique = false
	)

	private String password;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<UserRole> userRoles = new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private CustomUser createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public CustomUser(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CustomUser{" +
				"id='" + id + '\'' +
				", username=" + username +
				", password=" + password +
				", userRoles=" + userRoles +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
