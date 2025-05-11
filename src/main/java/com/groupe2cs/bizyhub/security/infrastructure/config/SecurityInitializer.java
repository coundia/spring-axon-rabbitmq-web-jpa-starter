package com.groupe2cs.bizyhub.security.infrastructure.config;

	import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
	import static com.groupe2cs.bizyhub.security.infrastructure.config.ConstanteConfig.*;
	import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

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
@Transactional
public void init() {

var tenant = findOrCreateTenant(DEFAULT_TENANT);

createPermissions(tenant);

var roles = createRoles(tenant);

assignPermissionsToRole(roles.get(ROLE_ADMIN));

createUserIfNotExist(tenant, ADMIN_USERNAME, PASSWORD_ADMIN, roles.get(ROLE_ADMIN));
createUserIfNotExist(tenant, USER_USERNAME, PASSWORD_USER, roles.get(ROLE_USER));
}

private Tenant findOrCreateTenant(String tenantName) {
return tenantRepository.findByName(tenantName).stream()
.findFirst().orElseGet(() ->
tenantRepository.save(Tenant.builder()
.id(UUID.randomUUID().toString())
.name(tenantName)
.build()
)
);
}

private void createPermissions(Tenant tenant) {
DEFAULT_PERMISSIONS.forEach(name ->
permissionRepository.findByNameAndTenantName(name, tenant.getName()).stream()
.findFirst().orElseGet(() ->
permissionRepository.save(Permission.builder()
.id(UUID.randomUUID().toString())
.name(name)
.tenant(tenant)
.build()
)
)
);
}

private Map<String, Role> createRoles(Tenant tenant) {
var result = new HashMap<String, Role>();
result.put(ROLE_ADMIN, findOrCreateRole(tenant, ROLE_ADMIN));
result.put(ROLE_USER, findOrCreateRole(tenant, ROLE_USER));
return result;
}

private Role findOrCreateRole(Tenant tenant, String name) {
return roleRepository.findByNameAndTenantName(name, tenant.getName()).stream()
.findFirst().orElseGet(() ->
roleRepository.save(Role.builder()
.id(UUID.randomUUID().toString())
.name(name)
.tenant(tenant)
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

private void createUserIfNotExist(Tenant tenant, String username, String rawPassword, Role role) {
userRepository.findByUsernameAndTenantName(username, tenant.getName()).stream()
.findFirst().orElseGet(() -> {
var user = userRepository.save(User.builder()
.id(UUID.randomUUID().toString())
.username(username)
.password(passwordEncoder.encode(rawPassword))
.tenant(tenant)
.build()
);

userRoleRepository.save(UserRole.builder()
.id(UUID.randomUUID().toString())
.user(user)
.role(role)
.build()
);

return user;
});
}
}
