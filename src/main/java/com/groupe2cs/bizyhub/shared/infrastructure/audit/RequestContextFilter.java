package com.groupe2cs.bizyhub.shared.infrastructure.audit;

import com.groupe2cs.bizyhub.security.application.service.UserPrincipal;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

public class RequestContextFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String tenantId = httpRequest.getHeader("X-Tenant-ID");
		if (tenantId != null) {
			//RequestContext.setTenantId(tenantId);
		}

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getPrincipal() instanceof UserPrincipal principal) {
			//RequestContext.setUsername(principal.getUsername());
		}

		try {
			chain.doFilter(request, response);
		} finally {
			//RequestContext.clear();
		}
	}
}
