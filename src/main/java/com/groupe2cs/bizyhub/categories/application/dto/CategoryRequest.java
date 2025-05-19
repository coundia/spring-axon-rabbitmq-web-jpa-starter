package com.groupe2cs.bizyhub.categories.application.dto;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
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
@Schema(name = "CategoryRequest", description = "Request payload for Category operations")
public class CategoryRequest implements Serializable {

	@Schema(description = "", example = "6af73422-f39e-4820-a509-f2826b686e0e")
	private String name;

	@Schema(description = "", example = "57d8a2d7-95f8-4b96-8fec-f833c8980386")
	private String typeCategoryRaw;

	@Schema(description = "", example = "cef13e66-9e8b-44e5-b1d8-511a3a194070")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "66693863-d4d5-4748-83f0-1afc8c99b2d9")
	private String reference;


}
