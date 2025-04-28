package com.groupe2cs.bizyhub.security.infrastructure.config;

import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.groupe2cs.bizyhub.security.infrastructure.config.ConstanteConfig.*;

@Component
@RequiredArgsConstructor
public class SecurityInitializer {

	private final RoleRepository roleRepository;
	private final PermissionRepository permissionRepository;
	private final RolePermissionRepository rolePermissionRepository;
	private final UserRepository userRepository;
	private final UserRoleRepository userRoleRepository;
	private final PasswordEncoder passwordEncoder;
	private final TenantRepository tenantRepository;

	@PostConstruct
	public void init() {
		createPermissions();
		var roles = createRoles();
		assignPermissionsToRole(roles.get(ROLE_ADMIN));
		createUserIfNotExist(ADMIN_USERNAME, PASSWORD_ADMIN, roles.get(ROLE_ADMIN));
		createUserIfNotExist(USER_USERNAME, PASSWORD_USER, roles.get(ROLE_USER));
		addTenantAndAssignToUser(DEFAULT_TENANT, ADMIN_USERNAME);
		addTenantAndAssignToUser(DEFAULT_TENANT, USER_USERNAME);
	}

	private void createPermissions() {
		DEFAULT_PERMISSIONS.forEach(name ->
				permissionRepository.findByNameAndTenantName(name, DEFAULT_TENANT).orElseGet(() ->
						permissionRepository.save(Permission.builder()
								.id(UUID.randomUUID().toString())
								.name(name)
								.build()
						)
				)
		);
	}

	private Map<String, Role> createRoles() {
		var result = new HashMap<String, Role>();
		result.put(ROLE_ADMIN, findOrCreateRole(ROLE_ADMIN));
		result.put(ROLE_USER, findOrCreateRole(ROLE_USER));
		return result;
	}

	private Role findOrCreateRole(String name) {
		return roleRepository.findByNameAndTenantName(name, DEFAULT_TENANT).orElseGet(() ->
				roleRepository.save(Role.builder()
						.id(UUID.randomUUID().toString())
						.name(name)
						.build()
				)
		);
	}

	private void assignPermissionsToRole(Role role) {
		permissionRepository.findAll().forEach(permission ->
				rolePermissionRepository.save(RolePermission.builder()
						.id(UUID.randomUUID().toString())
						.role(role)
						.permission(permission)
						.build()
				)
		);
	}

	private void createUserIfNotExist(String username, String rawPassword, Role role) {
		userRepository.findByUsernameAndTenantName(username, DEFAULT_TENANT).orElseGet(() -> {
			var user = userRepository.save(CustomUser.builder()
					.id(UUID.randomUUID().toString())
					.username(username)
					.password(passwordEncoder.encode(rawPassword))
					.build());

			userRoleRepository.save(UserRole.builder()
					.id(UUID.randomUUID().toString())
					.user(user)
					.role(role)
					.build()
			);
			return user;
		});
	}

	private void addTenantAndAssignToUser(String tenantName, String username) {
		var tenant = tenantRepository.findByName(tenantName).orElseGet(() ->
				tenantRepository.save(Tenant.builder()
						.id(UUID.randomUUID().toString())
						.name(tenantName)
						.build()
				));
		userRepository.findByUsernameAndTenantName(username, null).ifPresent(user -> {
			user.setTenant(tenant);
			userRepository.save(user);
		});
	}
}
