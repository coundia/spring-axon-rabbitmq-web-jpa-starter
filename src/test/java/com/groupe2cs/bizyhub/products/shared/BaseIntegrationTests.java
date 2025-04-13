package com.groupe2cs.bizyhub.products.shared;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

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

public String getBaseUrl() {
String uri = "http://" + this.host + ":" + this.port + "/api";
log.info("***************** URI ********************");
log.info(uri);
return uri;
}

public ResponseEntity<String> get(String uri) {
	return testRestTemplate.getForEntity(this.getBaseUrl() + uri, String.class);
	}

	public ResponseEntity<String> delete(String uri) {
		testRestTemplate.delete(this.getBaseUrl() + uri);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<String> post(String uri, Object request) {
		return testRestTemplate.postForEntity(this.getBaseUrl() + uri, request, String.class);
	}

	public ResponseEntity<String> put(String uri, Object request) {
		testRestTemplate.put(this.getBaseUrl() + uri, request);
		return ResponseEntity.ok().build();
	}
	public <T> ResponseEntity<T> postForEntity(String uri, Object request, Class<T> responseType) {
		return this.testRestTemplate.postForEntity(this.getBaseUrl() + uri, request, responseType);
	}

	public <T> ResponseEntity<T> getForEntity(String uri, Class<T> responseType) {
		return this.testRestTemplate.getForEntity(this.getBaseUrl() + uri, responseType);
	}
	public  HttpEntity<ByteArrayResource> createFile() {
			byte[] content = "Fake PDF content".getBytes();
			ByteArrayResource resource = new ByteArrayResource(content) {
			@Override
			public String getFilename() {
			return "file.pdf";
			}
			};
			HttpHeaders partHeaders = new HttpHeaders();
			partHeaders.setContentType(MediaType.APPLICATION_PDF);
			return new HttpEntity<>(resource, partHeaders);
	}

}
