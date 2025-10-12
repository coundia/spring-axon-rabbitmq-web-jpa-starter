package com.groupe2cs.bizyhub.stock.application.usecase;

import com.groupe2cs.bizyhub.security.application.service.UserPrincipal;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockMovement;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockMovementRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StockMovementGateTests {

	@Mock
	private StockMovementRepository repository;
	@InjectMocks
	private StockMovementGate gate;

	private StockMovement sampleStockMovement;
	private Authentication ownerAuth;
	private Authentication sameTenantAuth;
	private Authentication crossTenantAuth;
	private Authentication adminAuth;
	private Authentication unauthenticated;

	static Stream<Arguments> readScenarios() {
		return Stream.of(
				Arguments.of("owner", true),
				Arguments.of("same-tenant", true),
				Arguments.of("cross-tenant", false),
				Arguments.of("admin", true),
				Arguments.of("unauthenticated", false)
		);
	}

	@BeforeEach
	void setUp() {
		var tenantA = new Tenant("tenant-A");
		var tenantB = new Tenant("tenant-B");

		var user1 = User.builder().id("user-1").username("user-1").password("pwd").tenant(tenantA).build();
		var user2 = User.builder().id("user-2").username("user-2").password("pwd").tenant(tenantA).build();
		var user3 = User.builder().id("user-3").username("user-3").password("pwd").tenant(tenantB).build();
		var adminUser = User.builder().id("admin-1").username("admin-1").password("pwd")
				.tenant(new Tenant("tenant-X")).build();

		sampleStockMovement = StockMovement.builder()
				.id("tx-123")
				.createdBy(user1)
				.tenant(tenantA)
				.build();

		ownerAuth = new UsernamePasswordAuthenticationToken(
				new UserPrincipal(user1), null, List.of()
		);
		sameTenantAuth = new UsernamePasswordAuthenticationToken(
				new UserPrincipal(user2), null, List.of()
		);
		crossTenantAuth = new UsernamePasswordAuthenticationToken(
				new UserPrincipal(user3), null, List.of()
		);
		adminAuth = new UsernamePasswordAuthenticationToken(
				new UserPrincipal(adminUser), null,
				List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
		);
		unauthenticated = new UsernamePasswordAuthenticationToken(
				new UserPrincipal(user2), null, List.of()
		);
		((UsernamePasswordAuthenticationToken) unauthenticated).setAuthenticated(false);
	}

	@Test
	@DisplayName("canCreate: authenticated returns true")
	void canCreate_authenticated_returnsTrue() {
		assertThat(gate.canCreate(ownerAuth)).isTrue();
	}

	@Test
	@DisplayName("canCreate: unauthenticated or null returns false")
	void canCreate_unauthenticatedOrNull_returnsFalse() {
		assertThat(gate.canCreate(unauthenticated)).isFalse();
		assertThat(gate.canCreate(null)).isFalse();
	}

	@Test
	@DisplayName("canList: authenticated returns true")
	void canList_authenticated_returnsTrue() {
		assertThat(gate.canList(ownerAuth)).isTrue();
	}

	@Test
	@DisplayName("canList: unauthenticated or null returns false")
	void canList_unauthenticatedOrNull_returnsFalse() {
		assertThat(gate.canList(unauthenticated)).isFalse();
		assertThat(gate.canList(null)).isFalse();
	}

	@ParameterizedTest(name = "{0} → canRead?={1}")
	@MethodSource("readScenarios")
	void canRead_variousScenarios(String scenario, boolean expected) {
		Authentication auth;
		switch (scenario) {
			case "owner":
				auth = ownerAuth;
				break;
			case "same-tenant":
				auth = sameTenantAuth;
				break;
			case "cross-tenant":
				auth = crossTenantAuth;
				break;
			case "admin":
				auth = adminAuth;
				break;
			default:
				auth = unauthenticated;
		}

		if (auth == adminAuth) {
			assertThat(gate.canRead(auth, sampleStockMovement.getId())).isTrue();
			verifyNoInteractions(repository);
		} else if (!auth.isAuthenticated()) {
			assertThat(gate.canRead(auth, sampleStockMovement.getId())).isFalse();
			verifyNoInteractions(repository);
		} else {
			when(repository.findById(sampleStockMovement.getId()))
					.thenReturn(Optional.of(sampleStockMovement));
			assertThat(gate.canRead(auth, sampleStockMovement.getId())).isEqualTo(expected);
			verify(repository).findById(sampleStockMovement.getId());
		}
	}

	@Test
	@DisplayName("canRead: not found returns false")
	void canRead_notFound_returnsFalse() {
		lenient().when(repository.findById("missing"))
				.thenReturn(Optional.empty());
		assertThat(gate.canRead(ownerAuth, "missing")).isFalse();
	}

	@Test
	@DisplayName("canEdit and canDelete delegate to canRead")
	void canEditAndDelete_delegateToCanRead() {
		when(repository.findById(sampleStockMovement.getId()))
				.thenReturn(Optional.of(sampleStockMovement));
		assertThat(gate.canEdit(ownerAuth, sampleStockMovement.getId())).isTrue();
		assertThat(gate.canDelete(ownerAuth, sampleStockMovement.getId())).isTrue();
	}
}
