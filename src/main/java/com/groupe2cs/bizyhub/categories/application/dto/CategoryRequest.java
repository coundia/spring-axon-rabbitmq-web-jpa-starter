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

	@Schema(description = "", example = "f8747e50-02cf-4ae8-9e90-9d24e98ad934")
	private String code;
	@Schema(description = "", example = "e38aa30c-4f3c-4c4a-b41b-03754964db45")
	private String name;
	@Schema(description = "", example = "5af56a04-cd4c-42a5-b119-d345b3584705")
	private String remoteId;
	@Schema(description = "", example = "4ae70650-affd-4f9e-aa58-aed1db78367c")
	private String localId;
	@Schema(description = "", example = "3c5d27c0-622b-4bbd-9f7d-30d26f98c7b1")
	private String description;
	@Schema(description = "", example = "d4298a3e-d935-451c-bf0a-c59e147d2d87")
	private String typeEntry;
	@Schema(description = "", example = "6")
	private Integer version;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
