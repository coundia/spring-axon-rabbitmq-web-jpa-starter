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

	@Schema(description = "", example = "8c90cb80-9480-4333-af3d-8163d3ac2016")
	private String remoteId;
	@Schema(description = "", example = "2d909106-0e21-4767-9ce0-5284e7909c58")
	private String code;
	@Schema(description = "", example = "9a62d215-1469-45c8-ad8b-6f29de7fc5ff")
	private String name;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "44688bf6-0366-42b0-bbff-ec3872daf4b3")
	private String description;

}
