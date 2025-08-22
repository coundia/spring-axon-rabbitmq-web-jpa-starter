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

	@Schema(description = "", example = "262c3ee5-2038-44c2-ad1c-8585458e9b42")
	private String name;
	@Schema(description = "", example = "b24c9137-d6c8-436a-8547-2dd22924a460")
	private String typeCategoryRaw;
	@Schema(description = "", example = "5072406f-7cf9-4bfa-b4cc-e064d7d934aa")
	private String details;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
