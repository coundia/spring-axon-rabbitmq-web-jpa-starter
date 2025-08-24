package com.groupe2cs.bizyhub.units.application.dto;

import com.groupe2cs.bizyhub.units.domain.valueObject.*;
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
@Schema(name = "UnitRequest", description = "Request payload for Unit operations")
public class UnitRequest implements Serializable {

	@Schema(description = "", example = "2dad1ae1-8846-49bb-867e-616936c687ad")
	private String remoteId;
	@Schema(description = "", example = "3a95284b-3933-47fb-8e01-204bb736d6b0")
	private String code;
	@Schema(description = "", example = "3b1f388a-16b0-41b1-8866-6bb6070d74c3")
	private String name;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "4b2eace7-fe9a-4107-8332-d28777b8f1a1")
	private String description;

}
