package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.application.dto.ProductImageResponse;
import com.groupe2cs.bizyhub.products.application.dto.ProductRequest;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.application.usecase.ProductCreateApplicationImageService;
import com.groupe2cs.bizyhub.products.application.usecase.ProductImageService;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.entity.ProductImage;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductBisRepository;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductImageRepository;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.criteria.Predicate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.*;
import java.util.stream.Collectors;

@Tag(name = "marketplace", description = "Create product with files and list products with image urls")
@RestController
@RequiredArgsConstructor
public class ProductImageController {

	private final ProductCreateApplicationImageService productCreateService;
	private final ProductImageService imageService;
	private final ProductBisRepository productRepository;
	private final ProductImageRepository productImageRepository;

	private static String baseUrl() {
		return ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
	}

	private static String absoluteInlineUrl(String productId, String imageId) {
		return baseUrl() + "/api/public/products/" + productId + "/images/" + imageId;
	}

	private static ProductImageResponse imgWithAbsoluteUrl(String productId, String imageId, ProductImageResponse src) {
		return ProductImageResponse.builder()
				.id(src.getId())
				.filename(src.getFilename())
				.contentType(src.getContentType())
				.size(src.getSize())
				.createdAt(src.getCreatedAt())
				.url(absoluteInlineUrl(productId, imageId))
				.build();
	}

	@PreAuthorize("@productGate.canCreate(authentication)")
	@PostMapping(
			value = "/api/v1/marketplace",
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@Operation(summary = "Create product with files")
	@RequestBody(required = true, content = @Content(
			mediaType = MediaType.MULTIPART_FORM_DATA_VALUE,
			schema = @Schema(implementation = CreateProductWithFilesSchema.class)))
	@ApiResponse(responseCode = "201", description = "Created",
			content = @Content(schema = @Schema(implementation = ProductWithImagesResponse.class)))
	public ResponseEntity<?> createWithFiles(
			@AuthenticationPrincipal Jwt jwt,
			@RequestPart("product") @Valid ProductRequest product,
			@RequestPart(value = "files", required = false) List<MultipartFile> files
	) {
		try {
			MetaRequest meta = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt))
					.tenantId(RequestContext.getTenantId(jwt))
					.build();
			meta.setIsAdmin(RequestContext.isAdmin(jwt));

			ProductResponse created = productCreateService.createProductSync(product, meta);

			List<ProductImageResponse> images =
					(files == null ? List.<ProductImageResponse>of()
							: files.stream().map(f -> imageService.upload(created.getId(), f)).toList())
							.stream()
							.map(img -> imgWithAbsoluteUrl(created.getId(), img.getId(), img))
							.toList();

			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ProductWithImagesResponse(created, images));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					ApiResponseDto.builder()
							.code(0)
							.message(e.getMessage())
							.build()
			);
		}
	}

	@GetMapping(value = "/api/public/marketplace", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "List published products with image urls, with search & filters")
	@ApiResponse(responseCode = "200", description = "OK",
			content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductListItemResponse.class))))
	public ResponseEntity<?> listWithImageUrls(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int size,
			@RequestParam(defaultValue = "updatedAtAudit,DESC") String sort,
			@RequestParam(required = false) String q,
			@RequestParam(required = false) String category,
			@RequestParam(required = false) String company,
			@RequestParam(required = false) Double minPrice,
			@RequestParam(required = false) Double maxPrice,
			@RequestParam(defaultValue = "PUBLISH") String statuses
	) {
		try {
			String[] s = sort.split(",", 2);
			Sort.Direction dir = s.length > 1 ? Sort.Direction.fromString(s[1]) : Sort.Direction.DESC;
			String prop = s.length > 0 ? s[0] : "updatedAtAudit";
			var pageable = PageRequest.of(page, size, Sort.by(dir, prop));

			List<String> statusList = Arrays.stream(
							(statuses == null || statuses.isBlank() ? "PUBLISH" : statuses).split(","))
					.map(v -> v == null ? "" : v.trim().toUpperCase())
					.filter(v -> !v.isBlank())
					.distinct()
					.toList();

			Specification<Product> spec = Specification.where(null);
			spec = spec.and((root, query, cb) -> {
				var upp = cb.upper(root.get("statuses"));
				List<Predicate> orPreds = new ArrayList<>();
				for (String st : statusList) {
					orPreds.add(cb.equal(upp, st));
				}
				return cb.or(orPreds.toArray(new Predicate[0]));
			});

			if (q != null && !q.isBlank()) {
				final String like = "%" + q.trim().toLowerCase() + "%";
				spec = spec.and((root, query, cb) -> cb.or(
						cb.like(cb.lower(root.get("name")), like),
						cb.like(cb.lower(root.get("code")), like),
						cb.like(cb.lower(root.get("description")), like),
						cb.like(cb.lower(root.get("barcode")), like)
				));
			}

			if (category != null && !category.isBlank()) {
				final String c = category.trim();
				spec = spec.and((root, query, cb) -> cb.equal(root.get("category"), c));
			}

			if (company != null && !company.isBlank()) {
				final String comp = company.trim();
				spec = spec.and((root, query, cb) -> cb.equal(root.get("company"), comp));
			}

			if (minPrice != null) {
				spec = spec.and((root, query, cb) -> cb.greaterThanOrEqualTo(root.get("defaultPrice"), minPrice));
			}
			if (maxPrice != null) {
				spec = spec.and((root, query, cb) -> cb.lessThanOrEqualTo(root.get("defaultPrice"), maxPrice));
			}

			var pageData = productRepository.findAll(spec, pageable);
			List<String> ids = pageData.getContent().stream().map(Product::getId).toList();
			Map<String, List<ProductImage>> imagesByProduct = productImageRepository
					.findByProductIdIn(ids)
					.stream()
					.collect(Collectors.groupingBy(img -> img.getProduct().getId()));

			List<ProductListItemResponse> content = pageData.getContent().stream().map(p -> {
				List<String> urls = imagesByProduct.getOrDefault(p.getId(), List.of())
						.stream()
						.sorted(Comparator.comparing(ProductImage::getCreatedAtAudit))
						.map(img -> absoluteInlineUrl(p.getId(), img.getId()))
						.toList();
				return new ProductListItemResponse(
						p.getId(),
						p.getCode(),
						p.getName(),
						p.getDescription(),
						p.getDefaultPrice(),
						p.getQuantity(),
						p.getHasSold(),
						p.getHasPrice(),
						urls
				);
			}).toList();

			return ResponseEntity.ok(new ProductSliceResponse(content, pageData.hasNext(), page, size));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					ApiResponseDto.builder()
							.code(0)
							.message(e.getMessage())
							.build()
			);
		}
	}

	@GetMapping(value = "/api/public/products/{productId}/images/{imageId}")
	@Operation(summary = "Read product image (inline)",
			description = "Returns the file bytes with its original content type for inline rendering.")
	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "*/*"))
	public ResponseEntity<Resource> readInline(
			@PathVariable String productId,
			@PathVariable String imageId
	) {
		Resource file = imageService.loadAsResource(productId, imageId);
		ProductImage img = productImageRepository.findById(imageId).orElseThrow();
		MediaType type = MediaType.APPLICATION_OCTET_STREAM;
		try {
			if (img.getContentType() != null) {
				type = MediaType.parseMediaType(img.getContentType());
			}
		} catch (Exception ignored) {
		}
		return ResponseEntity.ok()
				.contentType(type)
				.body(file);
	}

	public static class CreateProductWithFilesSchema {
		@Schema(implementation = ProductRequest.class)
		public ProductRequest product;
		@ArraySchema(schema = @Schema(type = "string", format = "binary"))
		public List<MultipartFile> files;
	}

	@Value
	public static class ProductWithImagesResponse {
		ProductResponse product;
		@ArraySchema(schema = @Schema(implementation = ProductImageResponse.class))
		List<ProductImageResponse> images;
	}

	@Value
	public static class ProductListItemResponse {
		String id;
		String code;
		String name;
		String description;
		Double defaultPrice;
		int quantity;
		boolean hasSold;
		boolean hasPrice;
		List<String> imageUrls;
	}

	@Value
	public static class ProductSliceResponse {
		List<ProductListItemResponse> content;
		boolean hasNext;
		int page;
		int size;
	}
}
