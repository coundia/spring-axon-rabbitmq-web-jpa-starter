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

	@Schema(description = "", example = "d1dca21d-c417-4ef8-a0a1-93127153363d")
	private String code;
	@Schema(description = "", example = "6afa6f02-d681-41df-a374-7118f7c21b52")
	private String name;
	@Schema(description = "", example = "a8698e14-3e97-442b-99af-8945dba16993")
	private String remoteId;
	@Schema(description = "", example = "bcb7eba9-a732-4b82-b53e-84417573f385")
	private String description;
	@Schema(description = "", example = "ad6aac4f-491d-4798-b91e-26b87de4c8b8")
	private String typeEntry;
	@Schema(description = "", example = "47")
	private Integer version;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
