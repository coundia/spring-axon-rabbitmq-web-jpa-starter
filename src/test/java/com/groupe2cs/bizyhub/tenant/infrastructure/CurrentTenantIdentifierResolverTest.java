package com.groupe2cs.bizyhub.tenant.infrastructure;

import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrentTenantIdentifierResolverTest {

	@Mock
	private TenantRepository tenantRepository;

	@InjectMocks
	private CurrentTenantIdentifierResolverImpl resolver;

	@AfterEach
	void cleanup() {
		RequestContextHolder.resetRequestAttributes();
	}

	@Test
	void whenNoRequestAttributes_thenReturnDefaultTenant() {
		RequestContextHolder.resetRequestAttributes();
		assertEquals("default", resolver.resolveCurrentTenantIdentifier());
	}

	@Test
	void whenHeaderPresent_thenReturnHeaderValue() {
		when(tenantRepository.findByName("tenant123"))
				.thenReturn(Optional.of(Tenant.builder().id("tenant123").build()));

		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("X-Tenant-ID", "tenant123");
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		assertEquals("tenant123", resolver.resolveCurrentTenantIdentifier());
	}

	@Test
	void whenHeaderBlank_thenReturnDefaultTenant() {
		when(tenantRepository.findByName("default"))
				.thenReturn(Optional.of(Tenant.builder().id("default").build()));

		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("X-Tenant-ID", "");
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		assertEquals("default", resolver.resolveCurrentTenantIdentifier());
	}
}
