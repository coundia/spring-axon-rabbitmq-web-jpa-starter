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

	@Schema(description = "", example = "bb2718d0-ccbe-494c-8d77-ab41c479240f")
	private String name;

	@Schema(description = "", example = "e61d1fec-9b79-4f12-8648-0d4302b264d5")
	private String typeCategoryRaw;

	@Schema(description = "", example = "ae43e111-ff78-43d8-ba9a-5c8d58c469b8")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "dbbebf16-1bfc-4ea9-8dbf-00d3077fd4d0")
	private String reference;


}
