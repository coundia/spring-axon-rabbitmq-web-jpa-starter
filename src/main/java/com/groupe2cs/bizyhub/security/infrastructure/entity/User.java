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
@Table(name = "users")
public class User extends AbstractAuditableEntity {

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

	@Column(nullable = true,
			unique = false

	)

	private String firstName;

	@Column(nullable = true,
			unique = false

	)

	private String lastName;

	@Column(nullable = true,
			unique = false

	)

	private String email;

	@Column(nullable = true,
			unique = false

	)

	private String telephone;

	@Column(nullable = true, columnDefinition = "INT DEFAULT 10",
			unique = false

	)
	@Builder.Default
	private Integer limitPerDay = 10;

	@Column(nullable = true,
			unique = false

	)

	private Boolean isPremium;

	@Column(nullable = true,
			unique = false

	)

	private Boolean enabled;

	@Column(nullable = true,
			unique = false

	)

	private Boolean isBan;

	@Column(nullable = true, columnDefinition = "Text",
			unique = false

	)

	private String message;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<UserRole> userRoles = new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = true)
	private Tenant tenant;

	public User(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", username=" + username +
				", password=" + password +
				", firstName=" + firstName +
				", lastName=" + lastName +
				", email=" + email +
				", telephone=" + telephone +
				", limitPerDay=" + limitPerDay +
				", isPremium=" + isPremium +
				", enabled=" + enabled +
				", isBan=" + isBan +
				", message=" + message +
				", userRoles=" + userRoles +
				", createdBy=" + createdBy +
				", tenant=" + tenant +
				'}';
	}
}
