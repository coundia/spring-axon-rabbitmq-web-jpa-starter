package com.groupe2cs.bizyhub.shared;

	import com.groupe2cs.bizyhub.security.application.dto.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import org.springframework.http.*;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;

import java.util.Map;

@SpringBootTest(
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
properties = "spring.config.name=application-test"
)
@Profile("test")
@Slf4j
public class BaseIntegrationTests {

public String userId;

@LocalServerPort
public int port;

@Value("${server.address:localhost}")
public String host;

@Autowired
public TestRestTemplate testRestTemplate;

@Autowired
private JwtDecoder jwtDecoder;

public HttpHeaders headers;

@BeforeEach
void authenticate() {
login("admin", "admin");
}

public String getBaseUrl() {
String uri = "http://" + host + ":" + port + "/api";
return uri;
}

public Map<String, Object> getTokenClaims() {
String token = headers.getFirst(HttpHeaders.AUTHORIZATION).replace("Bearer ", "");
Jwt jwt = jwtDecoder.decode(token);
log.info("Claims: {}", jwt.getClaims());
return jwt.getClaims();
}

public String getUserId() {
return (String) getTokenClaims().get("userId");
}

public ResponseEntity<String> get(String uri) {
	log.info("Request URI: {}", getBaseUrl() + uri);
	return testRestTemplate.exchange(getBaseUrl() + uri, HttpMethod.GET, new HttpEntity<>(headers), String.class);
	}

	public ResponseEntity<String> delete(String uri) {
		log.info("Request URI: {}", getBaseUrl() + uri);
		return testRestTemplate.exchange(getBaseUrl() + uri,
		HttpMethod.DELETE,
		new HttpEntity<>(headers),
		String.class);
		}

		public <T> ResponseEntity<T> postForEntity(String uri, Object request, Class<T> responseType) {
			log.info("Request URI: {}", getBaseUrl() + uri);
			return testRestTemplate.postForEntity(getBaseUrl() + uri, new HttpEntity<>(request, headers), responseType);
			}

			public <T> ResponseEntity<T> getForEntity(String uri, Class<T> responseType) {
				log.info("Request URI: {}", getBaseUrl() + uri);
				return testRestTemplate.exchange(getBaseUrl() + uri, HttpMethod.GET, new HttpEntity<>(headers), responseType);
				}

				public ResponseEntity<String> post(String uri, Object request) {
					log.info("Request URI: {}", getBaseUrl() + uri);
					return testRestTemplate.postForEntity(getBaseUrl() + uri, new HttpEntity<>(request, headers), String.class);
					}

					public ResponseEntity<String> put(String uri, Object request) {
						log.info("Request URI: {}", getBaseUrl() + uri);
						return testRestTemplate.exchange(getBaseUrl() + uri,
						HttpMethod.PUT,
						new HttpEntity<>(request, headers),
						String.class);
						}

						public HttpEntity<ByteArrayResource> createFile() {
							byte[] content = "Fake PDF content".getBytes();
							ByteArrayResource resource = new ByteArrayResource(content) {
							@Override
							public String getFilename() {
							return "file.pdf";
							}
							};
							HttpHeaders partHeaders = new HttpHeaders();
							partHeaders.setContentType(MediaType.APPLICATION_PDF);
							partHeaders.setBearerAuth(headers.getFirst(HttpHeaders.AUTHORIZATION));
							return new HttpEntity<>(resource, partHeaders);
							}

							public  String login(String login,String password) {
							headers = new HttpHeaders();
							headers.setContentType(MediaType.APPLICATION_JSON);

							AuthRequestDto authRequest = AuthRequestDto.builder()
							.username(login)
							.password(password)
							.build();

							ResponseEntity<AuthResponseDto> response = testRestTemplate.postForEntity(
								getBaseUrl() + "/auth/login",
								new HttpEntity<>(authRequest),
								AuthResponseDto.class
								);

								if (response.getStatusCode().isError()) {
								throw new RuntimeException("Failed to authenticate test user: " + response.getBody());
								}

								String token = response.getBody().getToken();
								headers.setBearerAuth(token);

								userId = getUserId();
								return getUserId();
								}
								}
