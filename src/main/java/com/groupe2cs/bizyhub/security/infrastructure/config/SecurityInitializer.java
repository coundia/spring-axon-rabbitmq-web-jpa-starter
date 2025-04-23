package com.groupe2cs.bizyhub.security.infrastructure.config;

import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SecurityInitializer {

	private static final String ROLE_ADMIN = "ROLE_ADMIN";
	private static final String ROLE_USER = "ROLE_USER";
	private static final String ADMIN_USERNAME = "admin";
	private static final String USER_USERNAME = "user";
	private static final String PASSWORD_ADMIN = "admin";
	private static final String PASSWORD_USER = "user";
	private static final Set<String> DEFAULT_PERMISSIONS = Set.of("READ", "WRITE", "DELETE");

	private final RoleRepository roleRepository;
	private final PermissionRepository permissionRepository;
	private final RolePermissionRepository rolePermissionRepository;
	private final UserRepository userRepository;
	private final UserRoleRepository userRoleRepository;
	private final PasswordEncoder passwordEncoder;

	@PostConstruct
	public void init() {
		createPermissions();
		var roles = createRoles();
		assignPermissionsToRole(roles.get(ROLE_ADMIN));
		createUserIfNotExist(ADMIN_USERNAME, PASSWORD_ADMIN, roles.get(ROLE_ADMIN));
		createUserIfNotExist(USER_USERNAME, PASSWORD_USER, roles.get(ROLE_USER));
	}

	private void createPermissions() {
		DEFAULT_PERMISSIONS.forEach(name ->
				permissionRepository.findByName(name).orElseGet(() ->
						permissionRepository.save(Permission.builder()
								.id(UUID.randomUUID().toString())
								.name(name)
								.build()
						)
				)
		);
	}

	private Map<String, Role> createRoles() {
		Map<String, Role> result = new HashMap<>();
		result.put(ROLE_ADMIN, findOrCreateRole(ROLE_ADMIN));
		result.put(ROLE_USER, findOrCreateRole(ROLE_USER));
		return result;
	}

	private Role findOrCreateRole(String name) {
		return roleRepository.findByName(name).orElseGet(() ->
				roleRepository.save(Role.builder()
						.id(UUID.randomUUID().toString())
						.name(name)
						.build()
				)
		);
	}

	private void assignPermissionsToRole(Role role) {
		permissionRepository.findAll().forEach(permission ->
				rolePermissionRepository.findByRoleAndPermission(role, permission).orElseGet(() ->
						rolePermissionRepository.save(RolePermission.builder()
								.id(UUID.randomUUID().toString())
								.role(role)
								.permission(permission)
								.build()
						)
				)
		);
	}

	private void createUserIfNotExist(String username, String rawPassword, Role role) {
		userRepository.findByUsername(username).orElseGet(() -> {
			User user = userRepository.save(User.builder()
					.id(UUID.randomUUID().toString())
					.username(username)
					.password(passwordEncoder.encode(rawPassword))
					.build());

			userRoleRepository.save(UserRole.builder()
					.id(UUID.randomUUID().toString())
					.user(user)
					.role(role)
					.build());

			return user;
		});
	}
}
