package com.groupe2cs.bizyhub.products.application.dto;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import java.util.UUID;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ProductRequest", description = "Request payload for Product operations")
public class ProductRequest implements Serializable {

	@Schema(description = "", example = "b3e4d0b8-b626-47a8-9d4b-d1832f2d76a2")
	private String name;

	@Schema(description = "", example = "3662.69")
	private Double price;

	@Schema(description = "", example = "7c9b3e54-af51-49c5-b074-ded13f3c9883")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "931aaae7-d01e-4a32-a9f1-d3e40651220d")
	private String reference;


}
