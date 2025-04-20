package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
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
	public UserRole(String id) {
	this.id = id;
}

	@Override
 public String toString() {
	return "UserRole{" +
	"id='" + id + '\'' +
		", user=" + user +
		", role=" + role +
	'}';
	}
}
