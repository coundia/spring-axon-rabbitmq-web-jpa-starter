package com.groupe2cs.bizyhub.security.infrastructure.config;

import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static com.groupe2cs.bizyhub.security.infrastructure.config.ConstanteConfig.DEFAULT_TENANT;
import static com.groupe2cs.bizyhub.security.infrastructure.config.ConstanteConfig.TENANT_HEADER;


@Slf4j
@Component
@RequiredArgsConstructor
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

	private final TenantRepository tenantRepository;

	@Override
	public String resolveCurrentTenantIdentifier() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		log.info("Current tenant identifier resolver called");
		log.info("ServletRequestAttributes: {}", attrs);

		if (attrs == null) {
			return DEFAULT_TENANT;
		}
		HttpServletRequest request = attrs.getRequest();

		if (request != null) {
			log.info("Request: {}", request);
		} else {
			log.warn("Request is null");
		}

		String tenantId = request.getHeader(TENANT_HEADER);

		if (tenantId == null || tenantId.isEmpty()) {
			log.warn("Tenant ID not found in request header, using default tenant");
			tenantId = DEFAULT_TENANT;
		}

		log.info("Current tenant identifier: {}", tenantId);

		return tenantRepository.findByName(tenantId).orElseThrow().getId();
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}
}

