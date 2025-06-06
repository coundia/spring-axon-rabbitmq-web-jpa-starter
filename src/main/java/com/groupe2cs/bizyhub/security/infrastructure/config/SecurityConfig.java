package com.groupe2cs.bizyhub.security.infrastructure.config;

import com.groupe2cs.bizyhub.security.application.service.CustomUserDetailsService;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

import static com.groupe2cs.bizyhub.security.infrastructure.config.ConstanteConfig.*;


@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

	private final CustomUserDetailsService userDetailsService;

	@Value("${security.jwt.secret}")
	private String jwtKey;

	@Bean
	public AuthenticationManager authenticationManager() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return new ProviderManager(authProvider);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.cors(Customizer.withDefaults())
				.csrf(csrf -> csrf.disable())
				.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth
						.requestMatchers(
								"/api/auth/**",
								"/api/v1/status",
								"/api/v1/status/fallback",
								"/swagger-ui.html",
								"/swagger-ui/**",
								"/v3/api-docs/**",
								"/v3/api-docs.yaml",
								"/swagger-resources/**",
								"/webjars/**",
								"/actuator/**"

						).permitAll()
						.requestMatchers("/actuator/prometheus").permitAll()
						.requestMatchers("/api/public/**").permitAll()
						.requestMatchers("/api/v1/admin/**").hasAuthority(IS_ADMIN)
						.anyRequest().authenticated()
				)
				.oauth2ResourceServer(oauth2 -> oauth2
						.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()))
				);

		return http.build();
	}

	@Bean
	public JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder
				.withSecretKey(getSecretKey())
				.macAlgorithm(MacAlgorithm.HS512)
				.build();
	}

	@Bean
	public JwtEncoder jwtEncoder() {
		return new NimbusJwtEncoder(new ImmutableSecret<>(getSecretKey()));
	}

	private SecretKey getSecretKey() {
		byte[] keyBytes = Base64.getDecoder().decode(jwtKey);
		return new SecretKeySpec(keyBytes, "HmacSHA512");
	}

	@Bean
	public OpenAPI customOpenAPI() {

		Server megastoreServer = new Server()
				.url("https://cloud.megastore.sn")
				.description("Production - Megastore");


		return new OpenAPI()
				.info(new Info().title("API").version("1.0"))
				.addSecurityItem(new SecurityRequirement()
						.addList("bearerAuth")
						.addList("ApiKeyAuth")
						.addList("tenantName"))
				.components(new io.swagger.v3.oas.models.Components()
						.addSecuritySchemes("bearerAuth",
								new SecurityScheme()
										.type(SecurityScheme.Type.HTTP)
										.scheme("bearer")
										.bearerFormat("JWT"))
						.addSecuritySchemes("ApiKeyAuth",
								new SecurityScheme()
										.type(SecurityScheme.Type.APIKEY)
										.in(SecurityScheme.In.HEADER)
										.name(API_KEY_HEADER))
						.addSecuritySchemes("tenantName",
								new SecurityScheme()
										.type(SecurityScheme.Type.APIKEY)
										.in(SecurityScheme.In.HEADER)
										.name(TENANT_HEADER))
				);
	}


	@Bean(name = "apiKeyFilterBean")
	public FilterRegistrationBean<ApiKeyFilter> apiKeyFilter(ApiKeyFilter filter) {
		FilterRegistrationBean<ApiKeyFilter> registration = new FilterRegistrationBean<>();
		registration.setFilter(filter);
		registration.addUrlPatterns("/api/v1/*");
		registration.setOrder(1);
		return registration;
	}


	@Bean
	public JwtAuthenticationConverter jwtAuthenticationConverter() {
		JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
		grantedAuthoritiesConverter.setAuthoritiesClaimName("scope");
		grantedAuthoritiesConverter.setAuthorityPrefix("");

		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
		return jwtAuthenticationConverter;
	}
}
