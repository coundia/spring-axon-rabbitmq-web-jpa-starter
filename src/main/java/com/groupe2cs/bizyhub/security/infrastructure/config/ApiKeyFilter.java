package com.groupe2cs.bizyhub.security.infrastructure.config;

import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.application.query.FindByApiKeyKeyQuery;
import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyKey;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApiKeyFilter implements Filter {

	private final QueryGateway queryGateway;

	@Value("${module.apiKey:false}")
	private String activeApiKeyService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String apiKey = httpRequest.getHeader("X-API-KEY");

		String requestURI = httpRequest.getRequestURI();

		if (
				requestURI.startsWith("/api/v1/queries/apiKey") ||
						requestURI.startsWith("/api/v1/commands/apiKey") ||
						activeApiKeyService.equals("false")
		) {
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
			ApiKeyResponse
					apiKeyResponse =
					queryGateway.query(new FindByApiKeyKeyQuery(ApiKeyKey.create(apiKey)), ApiKeyResponse.class).join();
			log.info("Valid API Key: '{}' for '{}'", apiKey, apiKeyResponse.getUsername());
			chain.doFilter(request, response);
		} catch (Exception e) {
			log.warn("Invalid API Key: '{}' ", apiKey);
			//e.printStackTrace();
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid API Key");
		}
	}
}



