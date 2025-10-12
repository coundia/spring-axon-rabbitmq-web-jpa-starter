package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.dto.ProductImageResponse;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.entity.ProductImage;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductImageRepository;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductImageService {

	private final ProductRepository productRepository;
	private final ProductImageRepository productImageRepository;

	@Value("${app.file.upload-dir}")
	private String rootDir;

	@Value("${app.public-base-url:}")
	private String publicBaseUrl;

	@Value("${app.projection.retry.attempts:20}")
	private int retryAttempts;

	@Value("${app.projection.retry.sleep-ms:100}")
	private long retrySleepMs;

	public ProductImageResponse upload(String productId, MultipartFile file) {
		Product product = findProductEventually(productId);
		String ext = extractExtension(file.getOriginalFilename());
		String imageId = UUID.randomUUID().toString();
		String filename = imageId + (ext.isEmpty() ? "" : "." + ext);
		Path dir = Paths.get(rootDir, productId);
		Path target = dir.resolve(filename);
		try {
			Files.createDirectories(dir);
			Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		String urlPath = "/api/public/products/" + productId + "/images/" + imageId;
		String absoluteUrl = buildAbsoluteUrl(urlPath);
		ProductImage entity = ProductImage.builder()
				.id(imageId)
				.product(product)
				.filename(filename)
				.contentType(file.getContentType() == null ? "application/octet-stream" : file.getContentType())
				.size(file.getSize())
				.url(absoluteUrl)
				.build();
		entity = productImageRepository.save(entity);
		return ProductImageResponse.builder()
				.id(entity.getId())
				.filename(entity.getFilename())
				.contentType(entity.getContentType())
				.size(entity.getSize())
				.url(entity.getUrl())
				.createdAt(entity.getCreatedAtAudit())
				.build();
	}

	@Transactional(readOnly = true)
	public List<ProductImageResponse> list(String productId) {
		return productImageRepository.findByProductIdOrderByUpdatedAtAuditDescCreatedAtAuditDesc(productId).stream()
				.map(e ->
						ProductImageResponse.builder()
								.id(e.getId())
								.filename(e.getFilename())
								.contentType(e.getContentType())
								.size(e.getSize())
								.url(normalizeUrl(e.getUrl()))
								.createdAt(e.getCreatedAtAudit())
								.build()
				).toList();
	}

	public void delete(String productId, String imageId) {
		ProductImage image = productImageRepository.findById(imageId).orElseThrow();
		if (!image.getProduct().getId().equals(productId)) throw new RuntimeException("not-found");
		Path path = Paths.get(rootDir, productId, image.getFilename());
		try {
			Files.deleteIfExists(path);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		productImageRepository.delete(image);
	}

	@Transactional(readOnly = true)
	public Resource loadAsResource(String productId, String imageId) {
		ProductImage image = productImageRepository.findById(imageId).orElseThrow();
		if (!image.getProduct().getId().equals(productId)) throw new RuntimeException("not-found");
		Path path = Paths.get(rootDir, productId, image.getFilename());
		return new FileSystemResource(path);
	}

	private String extractExtension(String name) {
		if (name == null) return "";
		int i = name.lastIndexOf('.');
		return i == -1 ? "" : name.substring(i + 1);
	}

	private Product findProductEventually(String productId) {
		for (int i = 0; i < retryAttempts; i++) {
			Optional<Product> p = productRepository.findById(productId);
			if (p.isPresent()) return p.get();
			try {
				Thread.sleep(retrySleepMs);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}
		throw new NoSuchElementException("product-not-found:" + productId);
	}

	private String buildAbsoluteUrl(String urlPath) {
		if (publicBaseUrl != null && !publicBaseUrl.isBlank()) {
			String
					base =
					publicBaseUrl.endsWith("/") ?
							publicBaseUrl.substring(0, publicBaseUrl.length() - 1) :
							publicBaseUrl;
			return base + urlPath;
		}
		return ServletUriComponentsBuilder.fromCurrentContextPath().path(urlPath).toUriString();
	}

	private String normalizeUrl(String url) {
		if (url == null || url.isBlank()) return url;
		if (url.startsWith("http://") || url.startsWith("https://")) return url;
		return buildAbsoluteUrl(url);
	}
}
