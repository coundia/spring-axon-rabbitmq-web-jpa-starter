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

	@Schema(description = "", example = "7443b578-1320-4041-976e-be6e8558740b")
	private String name;

	@Schema(description = "", example = "c1bc1b7d-5e98-42b5-b264-b1b4d2260ea9")
	private String typeCategoryRaw;

	@Schema(description = "", example = "f25b29ff-22d6-48f6-85c5-36c05562883f")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "8a09a670-73d7-4c18-acb9-ee8b1070dcb2")
	private String reference;


}
