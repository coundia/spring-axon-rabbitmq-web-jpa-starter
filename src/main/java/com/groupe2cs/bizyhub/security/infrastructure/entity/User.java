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
@Table(name = "users")
public class User {

	@Id
	private String id;

	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false, unique = false)
	private String password;
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<UserRole> userRoles = new HashSet<>();
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
	'}';
	}
}
