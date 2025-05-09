package com.groupe2cs.bizyhub.security.application.service;

import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
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

	private final CustomUser user;

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
		return true;
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
		if (user == null)
			return null;

		return user.getCreatedBy().getId();
	}
}

