package com.groupe2cs.bizyhub.security.application.service;

import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRole;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.IdentifiableUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserPrincipal implements UserDetails, IdentifiableUser {

	private final User user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (user == null || user.getUserRoles() == null) return Set.of();

		return user.getUserRoles().stream()
				.map(UserRole::getRole)
				.filter(role -> role.getRolePermissions() != null)
				.flatMap(role -> role.getRolePermissions().stream())
				.map(rp -> new SimpleGrantedAuthority(rp.getPermission().getName()))
				.collect(Collectors.toSet());
	}

	public Set<String> getRoles() {
		if (user == null || user.getUserRoles() == null) return Set.of();

		return user.getUserRoles().stream()
				.map(UserRole::getRole)
				.map(Role::getName)
				.collect(Collectors.toSet());
	}

	@Override
	public String getPassword() {
		return user != null ? user.getPassword() : null;
	}

	@Override
	public String getUsername() {
		return user != null ? user.getUsername() : null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		if (user == null) {

			return true;
		}

		if (user.getEnabled() == null) {

			return true;
		}

		return user.getEnabled();
	}

	@Override
	public String getId() {

		if (user == null)
			return null;

		return user.getId();
	}

	@Override
	public String getTenantId() {

		if (user == null)
			return null;

		if (user.getTenant() == null)
			return null;

		return user.getTenant().getId();
	}


	public String getCreatedBy() {
		if (user == null || user.getCreatedBy() == null) return null;
		return user.getCreatedBy().getId();
	}

	public User getUser() {
		return user;
	}

	public Integer getLimitPerDay() {
		if (user == null || user.getLimitPerDay() == null) return 0;
		return user.getLimitPerDay();
	}

	public Boolean isPremium() {
		if (user == null || user.getIsPremium() == null) return false;
		return user.getIsPremium();
	}

	public String getFirstName() {
		return user != null ? user.getFirstName() : null;
	}

	public String getLastName() {
		return user != null ? user.getLastName() : null;
	}

	public String getEmail() {
		return user != null ? user.getEmail() : null;
	}

	public String getTelephone() {
		return user != null ? user.getTelephone() : null;
	}

	public Object getTenant() {
		return user != null ? user.getTenant() : null;
	}

	public Object getUserRoles() {
		return user != null ? user.getUserRoles() : null;
	}


	public Boolean isBan() {
		if (user == null || user.getIsBan() == null) return false;
		return user.getIsBan();
	}

	public String getMessage() {
		return user != null ? user.getMessage() : null;
	}

	@Override
	public String toString() {
		if (user == null) return "UserPrincipal{user=null}";

		return "UserPrincipal{" +
				"id=" + getId() +
				", username=" + getUsername() +
				", password=" + getPassword() +
				", firstName=" + getFirstName() +
				", lastName=" + getLastName() +
				", email=" + getEmail() +
				", telephone=" + getTelephone() +
				", limitPerDay=" + getLimitPerDay() +
				", isPremium=" + isPremium() +
				", userRoles=" + getRoles() +
				", createdBy=" + getCreatedBy() +
				", tenant=" + getTenantId() +
				'}';
	}

}

