package com.groupe2cs.bizyhub.products.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.groupe2cs.bizyhub.products.application.dto.ProductImageResponse;
import com.groupe2cs.bizyhub.products.application.dto.ProductRequest;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductImageControllerIntegrationTest extends BaseIntegrationTests {

	@Test
	void it_should_create_product_with_files_and_list_with_image_urls() throws Exception {
		ProductRequest requestDTO = new ProductRequest();
		requestDTO.setRemoteId(UUID.randomUUID().toString());
		requestDTO.setLocalId(UUID.randomUUID().toString());
		requestDTO.setCode("CODE-" + UUID.randomUUID());
		requestDTO.setName("NAME-" + UUID.randomUUID());
		requestDTO.setDescription("DESC-" + UUID.randomUUID());
		requestDTO.setBarcode(UUID.randomUUID().toString());
		requestDTO.setUnit("pc");
		requestDTO.setSyncAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setCategory(UUID.randomUUID().toString());
		requestDTO.setAccount(UUID.randomUUID().toString());
		requestDTO.setDefaultPrice(4824.97);
		requestDTO.setStatuses("ACTIVE");
		requestDTO.setPurchasePrice(4224.77);

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		String productJson = mapper.writeValueAsString(requestDTO);

		HttpHeaders productHeaders = new HttpHeaders();
		productHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> productPart = new HttpEntity<>(productJson, productHeaders);

		ByteArrayResource file1 = new ByteArrayResource("fake-image-content-1".getBytes(StandardCharsets.UTF_8)) {
			@Override
			public String getFilename() {
				return "image1.txt";
			}
		};
		ByteArrayResource file2 = new ByteArrayResource("fake-image-content-2".getBytes(StandardCharsets.UTF_8)) {
			@Override
			public String getFilename() {
				return "image2.txt";
			}
		};

		HttpHeaders fileHeaders = new HttpHeaders();
		fileHeaders.setContentType(MediaType.TEXT_PLAIN);

		HttpEntity<ByteArrayResource> filePart1 = new HttpEntity<>(file1, fileHeaders);
		HttpEntity<ByteArrayResource> filePart2 = new HttpEntity<>(file2, fileHeaders);

		MultiValueMap<String, Object> multipart = new LinkedMultiValueMap<>();
		multipart.add("product", productPart);
		multipart.add("files", filePart1);
		multipart.add("files", filePart2);

		HttpHeaders uploadHeaders = new HttpHeaders();
		uploadHeaders.putAll(headers);
		uploadHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<MultiValueMap<String, Object>> uploadRequest = new HttpEntity<>(multipart, uploadHeaders);

		ResponseEntity<ProductWithImagesResponse> createResp = testRestTemplate.exchange(
				getBaseUrl() + "/v1/marketplace",
				HttpMethod.POST,
				uploadRequest,
				ProductWithImagesResponse.class
		);

		assertThat(createResp.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(createResp.getBody()).isNotNull();
		assertThat(createResp.getBody().getProduct()).isNotNull();
		assertThat(createResp.getBody().getProduct().getId()).isNotBlank();
		assertThat(createResp.getBody().getImages()).isNotNull();
		assertThat(createResp.getBody().getImages().size()).isGreaterThanOrEqualTo(1);

		HttpEntity<Void> authGet = new HttpEntity<>(headers);

		ResponseEntity<Map<String, Object>> listResp = testRestTemplate.exchange(
				getBaseUrl() + "/v1/marketplace?page=0&size=50",
				HttpMethod.GET,
				authGet,
				new ParameterizedTypeReference<>() {
				}
		);

		assertThat(listResp.getStatusCode()).isEqualTo(HttpStatus.OK);
		Map<String, Object> slice = listResp.getBody();
		assertThat(slice).isNotNull();
		List<?> content = (List<?>) slice.get("content");
		assertThat(content).isNotEmpty();

		String createdId = createResp.getBody().getProduct().getId();
		String createdCode = createResp.getBody().getProduct().getCode();

		Optional<Map<String, Object>> createdItemOpt = content.stream()
				.filter(Map.class::isInstance)
				.map(o -> (Map<String, Object>) o)
				.filter(m -> createdId.equals(m.get("id")) || createdCode.equals(m.get("code")))
				.findFirst();

		assertThat(createdItemOpt).isPresent();
		Map<String, Object> createdItem = createdItemOpt.get();

		Object imageUrlsObj = createdItem.get("imageUrls");
		assertThat(imageUrlsObj).isInstanceOf(List.class);
		List<?> urls = (List<?>) imageUrlsObj;
		assertThat(urls.size()).isGreaterThanOrEqualTo(1);
		assertThat(urls.get(0)).isInstanceOf(String.class);
		assertThat(((String) urls.get(0))).contains("/v1/products/").contains("/download");
	}

	public static class ProductWithImagesResponse {
		private ProductResponse product;
		private List<ProductImageResponse> images;

		public ProductResponse getProduct() {
			return product;
		}

		public void setProduct(ProductResponse product) {
			this.product = product;
		}

		public List<ProductImageResponse> getImages() {
			return images;
		}

		public void setImages(List<ProductImageResponse> images) {
			this.images = images;
		}
	}
}
