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

	@Schema(description = "", example = "579947f2-2e2a-4ccc-87f8-32c5205be423")
	private String code;
	@Schema(description = "", example = "634b228a-f730-4844-8faa-a11da8c3b11a")
	private String name;
	@Schema(description = "", example = "334e83f5-3c97-4b29-ac70-4828eee37c4f")
	private String remoteId;
	@Schema(description = "", example = "562deaf8-9212-4094-b72b-8843f70f101c")
	private String localId;
	@Schema(description = "", example = "1b3f9487-9c3b-4aeb-a880-5c05e6f685f1")
	private String description;
	@Schema(description = "", example = "31f92f9d-e701-41ea-90e0-b7053a4b471a")
	private String typeEntry;
	@Schema(description = "", example = "8")
	private Integer version;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
