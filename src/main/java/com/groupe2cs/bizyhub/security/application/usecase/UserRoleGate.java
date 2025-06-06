package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.service.JwtService;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRole;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserRoleGate {

	private final UserRoleRepository repository;

	public boolean canRead(Authentication auth, String objectId) {
		log.debug("canRead called by user: {} for objectId: {}", auth != null ? auth.getName() : null, objectId);
		if (auth == null || !auth.isAuthenticated()) {
			log.warn("canRead denied: unauthenticated or null auth");
			return false;
		}
		if (hasRole(auth, "ROLE_ADMIN")) {
			log.info("canRead granted: user {} has ROLE_ADMIN", auth.getName());
			return true;
		}
		Optional<UserRole> opt = repository.findById(objectId);
		if (opt.isEmpty()) {
			log.warn("canRead denied: UserRole {} not found", objectId);
			return false;
		}
		UserRole tx = opt.get();

		String currentUserId = JwtService.extractClaim(auth, "userId");
		String currentTenantId = JwtService.extractClaim(auth, "tenantId");

		boolean owner = tx.getCreatedBy() != null
				&& currentUserId.equals(tx.getCreatedBy().getId());
		boolean sameTenant = tx.getTenant() != null
				&& currentTenantId.equals(tx.getTenant().getId());

		boolean result = owner || sameTenant;

		log.info("canRead result for user {}: owner={}, sameTenant={}, final={} for UserRole {}",
				currentUserId, owner, sameTenant, result, objectId);
		return result;
	}

	public boolean canCreate(Authentication auth) {
		boolean result = auth != null && auth.isAuthenticated();
		log.info("canCreate for user {}: {}", auth != null ? auth.getName() : null, result);
		return result;
	}

	public boolean canEdit(Authentication auth, String objectId) {
		log.debug("canEdit called by user: {} for objectId: {}", auth != null ? auth.getName() : null, objectId);
		boolean result = canRead(auth, objectId);
		log.info("canEdit result for user {} on UserRole {}: {}",
				auth != null ? auth.getName() : null,
				objectId,
				result);
		return result;
	}

	public boolean canDelete(Authentication auth, String objectId) {
		log.debug("canDelete called by user: {} for objectId: {}", auth != null ? auth.getName() : null, objectId);
		boolean result = canRead(auth, objectId);
		log.info("canDelete result for user {} on UserRole {}: {}",
				auth != null ? auth.getName() : null,
				objectId,
				result);
		return result;
	}

	public boolean canList(Authentication auth) {
		boolean result = auth != null && auth.isAuthenticated();
		log.info("canList for user {}: {}", auth != null ? auth.getName() : null, result);
		return result;
	}

	public boolean canDelete(String userId, String objectId) {
		log.debug("canDelete called with userId={} and objectId={}", userId, objectId);
		Optional<UserRole> opt = repository.findById(objectId);
		if (opt.isEmpty()) {
			log.warn("canDelete denied: UserRole {} not found", objectId);
			return false;
		}
		UserRole entity = opt.get();
		boolean result = entity.getCreatedBy() != null && userId.equals(entity.getCreatedBy().getId());
		log.info("canDelete result for userId {} on UserRole {}: {}", userId, objectId, result);
		return result;
	}

	private boolean hasRole(Authentication auth, String role) {
		boolean has = auth.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.anyMatch(role::equals);
		log.debug("hasRole check for user {}: role={}, result={}", auth.getName(), role, has);
		return has;
	}
}
