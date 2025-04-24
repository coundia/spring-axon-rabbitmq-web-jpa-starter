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
@Table(name = "users")
public class User {

	@Id
	private String id;

	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false, unique = false)
	private String password;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<UserRole> userRoles = new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "createdBy_id", nullable = true)
	private User createdBy;

	public User(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", username=" + username +
				", password=" + password +
				", userRoles=" + userRoles +
				", createdBy=" + createdBy +
				'}';
	}
}
