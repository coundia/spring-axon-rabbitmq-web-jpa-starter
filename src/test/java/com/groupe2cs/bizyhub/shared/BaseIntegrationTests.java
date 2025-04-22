package com.groupe2cs.bizyhub.shared;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		properties = "spring.config.name=application-test"
)
@Profile("test")
@Slf4j
public class BaseIntegrationTests {

	@LocalServerPort
	public int port;

	@Value("${server.address:localhost}")
	public String host;

	@Autowired
	public TestRestTemplate testRestTemplate;

	public HttpHeaders headers;

	@BeforeEach
	void authenticate() {

		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);


	}

	public String getBaseUrl() {
		String uri = "http://" + host + ":" + port + "/api";
		log.info(uri);
		return uri;
	}

	public ResponseEntity<String> get(String uri) {
		return testRestTemplate.exchange(getBaseUrl() + uri, org.springframework.http.HttpMethod.GET, new
				HttpEntity<>(headers), String.class);
	}

	public ResponseEntity
			<String> delete(String uri) {
		return testRestTemplate.exchange(getBaseUrl() + uri, org.springframework.http.HttpMethod.DELETE, new
				HttpEntity<>(headers), String.class);
	}

	public <T> ResponseEntity<T> postForEntity(String uri, Object request, Class
			<T> responseType) {
		return testRestTemplate.postForEntity(
				getBaseUrl() + uri,
				new HttpEntity<>(request, headers),
				responseType
		);
	}

	public <T> ResponseEntity
			<T> getForEntity(String uri, Class
			<T> responseType) {
		return testRestTemplate.exchange(getBaseUrl() + uri,
				org.springframework.http.HttpMethod.GET, new HttpEntity<>(headers), responseType);
	}

	public ResponseEntity<String> post(String uri, Object request) {
		return testRestTemplate.postForEntity(
				getBaseUrl() + uri,
				new HttpEntity<>(request, headers),
				String.class
		);
	}

	public ResponseEntity<String> put(String uri, Object request) {
		return testRestTemplate.exchange(getBaseUrl() + uri,
				org.springframework.http.HttpMethod.PUT, new HttpEntity<>(request, headers),
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
}
