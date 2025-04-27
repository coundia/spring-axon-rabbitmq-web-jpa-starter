package com.groupe2cs.bizyhub.security.application.service;

import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	private final CurrentTenantIdentifierResolver tenantIdentifierResolver;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) {

		String tenantId = tenantIdentifierResolver.resolveCurrentTenantIdentifier();
		log.debug("Loading user '{}' for tenant '{}'", username, tenantId);

		CustomUser user = userRepository.findByUsernameAndTenantId(username, tenantId)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

//load for lazy
		int roles = user.getUserRoles().size();
		log.info("nb roles: " + roles);
		if (roles == 0) {
			log.info("User has no roles");
		} else {
			log.info("User has roles");
		}
//load for lazy
		Tenant tenant = user.getTenant();

		if (tenant != null) {
			log.info("Tenant: " + tenant.getName());
		} else {
			log.info("User has no tenant");
		}

		return new UserPrincipal(user);
	}
}
