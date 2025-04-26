package com.groupe2cs.bizyhub.tenant.infrastructure;

	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
	import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Component
@RequiredArgsConstructor
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

private static final String DEFAULT_TENANT = "default";
private static final String TENANT_HEADER = "X-Tenant-ID";

private final TenantRepository tenantRepository;

@Override
public String resolveCurrentTenantIdentifier() {
ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
if (attrs == null) {
return DEFAULT_TENANT;
}
HttpServletRequest request = attrs.getRequest();
String tenantId = request.getHeader(TENANT_HEADER);

if(tenantId == null || tenantId.isEmpty()) {
tenantId = DEFAULT_TENANT;
}

log.info("Current tenant identifier: {}", tenantId);

return  tenantRepository.findByName(tenantId).orElseThrow().getId();
}

@Override
public boolean validateExistingCurrentSessions() {
return true;
}
}
