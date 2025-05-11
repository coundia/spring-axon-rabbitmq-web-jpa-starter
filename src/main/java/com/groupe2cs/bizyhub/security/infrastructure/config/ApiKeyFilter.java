package com.groupe2cs.bizyhub.security.infrastructure.config;

	import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyAppKey;
	import com.groupe2cs.bizyhub.security.application.query.FindByApiKeyAppKeyQuery;
	import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
	import static com.groupe2cs.bizyhub.security.infrastructure.config.ConstanteConfig.API_KEY_HEADER;
	import static com.groupe2cs.bizyhub.security.infrastructure.config.ConstanteConfig.TENANT_HEADER;
	import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Instant;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApiKeyFilter implements Filter {

private final QueryGateway queryGateway;

@Value("${module.apiKey:false}")
private boolean activeApiKeyService;

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
throws IOException, ServletException {

HttpServletRequest httpRequest = (HttpServletRequest) request;
String apiKey = httpRequest.getHeader(API_KEY_HEADER);
String requestURI = httpRequest.getRequestURI();

if (requestURI.startsWith("/api/v1/admin/queries/apiKey")
|| requestURI.startsWith("/api/v1/admin/commands/apiKey")
|| requestURI.contains("/api/v1/status")
|| !activeApiKeyService) {
log.info("Skipping API Key validation for request: {}", requestURI);
chain.doFilter(request, response);
return;
}

if (apiKey == null) {
log.warn("Missing API Key");
((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing API Key");
return;
}

try {
MetaRequest metaRequest = new MetaRequest();
metaRequest.setTenantName(httpRequest.getHeader(TENANT_HEADER));

ApiKeyResponse apiKeyResponse = queryGateway.query(
new FindByApiKeyAppKeyQuery(ApiKeyAppKey.create(apiKey), metaRequest),
ResponseTypes.instanceOf(ApiKeyResponse.class)
).join();

if (apiKeyResponse == null) {
log.warn("Invalid API Key: '{}'", apiKey);
((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid API Key");
return;
}

if (!apiKeyResponse.getActive()) {
log.warn("API Key is inactive: '{}'", apiKey);
((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "API Key is inactive");
return;
}

if (apiKeyResponse.getExpiration().isBefore(Instant.now())) {
log.warn("API Key is expired: '{}'", apiKey);
((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "API Key is expired");
return;
}

chain.doFilter(request, response);
} catch (Exception e) {
log.warn("Exception while validating API Key: '{}'", apiKey, e);
((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid API Key");
}
}
}
