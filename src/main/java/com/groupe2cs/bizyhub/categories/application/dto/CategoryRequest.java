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

	@Schema(description = "", example = "37e7371d-dbdd-402e-b16a-0ee98dd9a806")
	private String reference;

	@Schema(description = "", example = "e776fbc5-416c-45c3-b4f3-c7a6cf0e871b")
	private String name;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "38477d7f-9f3f-440b-8f86-df59e1c03934")
	private String typeCategory;

	@Schema(description = "", example = "17ba3418-98ac-4b9e-b160-1c66b73e2a60")
	private String parentId;

	@Schema(description = "", example = "false")
	private Boolean isDefault;

	@Schema(description = "", example = "73798885-a8d4-4f0c-94f4-f1a3cf7616e2")
	private String icon;

	@Schema(description = "", example = "6ae909de-cb5b-43ce-936e-92fb154698f1")
	private String colorHex;


}
