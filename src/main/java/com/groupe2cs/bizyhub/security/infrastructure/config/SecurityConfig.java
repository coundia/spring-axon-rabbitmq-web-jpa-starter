package com.groupe2cs.bizyhub.security.infrastructure.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthFilter;

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	return config.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	http
		.csrf(
			csrf -> csrf.disable()
			)
		.authorizeHttpRequests(
		auth -> auth
			.requestMatchers(
			"/api/auth/**",
			"/api/v1/status",
			"/swagger-ui.html",
			"/swagger-ui/**",
			"/v3/api-docs/**",
			"/v3/api-docs.yaml",
			"/swagger-resources/**",
			"/webjars/**"
		).permitAll()
			.anyRequest().authenticated()
		)
		.sessionManagement(
		sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);


		return http.build();
	}

		@Bean
		public OpenAPI customOpenAPI() {

			return new OpenAPI()
						.info(new Info().title("API").version("1.0"))
						.addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
						.components(new io.swagger.v3.oas.models.Components()
						.addSecuritySchemes("bearerAuth",
					new SecurityScheme()
						.type(SecurityScheme.Type.HTTP)
						.scheme("bearer")
						.bearerFormat("JWT")));
		}


}
