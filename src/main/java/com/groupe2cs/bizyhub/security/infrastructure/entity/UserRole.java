package com.groupe2cs.bizyhub.security.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_roles")
public class UserRole {

	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;

	public UserRole(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserRole{" +
				"id='" + id + '\'' +
				", user=" + user +
				", role=" + role +
				", createdBy=" + createdBy +
				'}';
	}
}
