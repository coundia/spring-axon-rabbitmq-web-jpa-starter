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

	@Schema(description = "", example = "ae172336-6770-458c-a68c-5fa9668d5f95")
	private String code;
	@Schema(description = "", example = "e06cdfda-ea66-4eca-8cf8-66e56c4fa7e9")
	private String name;
	@Schema(description = "", example = "6947f2dd-88af-4a31-b7e0-41d6409eedee")
	private String remoteId;
	@Schema(description = "", example = "4dd225eb-c379-4192-ade5-b6626654fc97")
	private String localId;
	@Schema(description = "", example = "5b6e3c18-c1fe-43ae-9914-b16a4b827880")
	private String account;
	@Schema(description = "", example = "50c46870-7ea8-4aa0-843c-43b0aaec3556")
	private String status;
	@Schema(description = "", example = "false")
	private Boolean isPublic;
	@Schema(description = "", example = "a7424cb5-96e2-492e-ba76-c0b327f2692d")
	private String description;
	@Schema(description = "", example = "ee201365-7c61-42bf-a61a-faa1fe4c7f8f")
	private String typeEntry;
	@Schema(description = "", example = "3")
	private Integer version;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
