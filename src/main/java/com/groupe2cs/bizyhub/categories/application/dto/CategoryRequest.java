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

	@Schema(description = "", example = "39bdbce2-556e-4fb4-bd91-bff3640decf5")
	private String code;
	@Schema(description = "", example = "efcd211e-bfbc-4e72-80fc-742c58271770")
	private String name;
	@Schema(description = "", example = "e52e992e-b794-4e47-b7f5-926796f84496")
	private String remoteId;
	@Schema(description = "", example = "fa658bf9-1310-40e0-a0f6-cecafe325305")
	private String localId;
	@Schema(description = "", example = "a0ced7b6-77b0-45ad-bab1-c5ff0f4e76ea")
	private String description;
	@Schema(description = "", example = "f57f593b-fe5a-4743-952b-8af6da16d4dc")
	private String typeEntry;
	@Schema(description = "", example = "75")
	private Integer version;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
