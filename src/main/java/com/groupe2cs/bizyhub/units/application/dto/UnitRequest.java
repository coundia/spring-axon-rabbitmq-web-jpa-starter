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

	@Schema(description = "", example = "12c3d8dc-1219-4a8c-b7f9-01608cbe5270")
	private String remoteId;
	@Schema(description = "", example = "c627ff07-5130-43b4-a316-ba5d32c4b973")
	private String localId;
	@Schema(description = "", example = "3238a971-a911-4c73-bc59-0757387f44ff")
	private String code;
	@Schema(description = "", example = "384da136-072d-4f88-8464-ef7c0646937d")
	private String name;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "378e02a0-5f26-4a2c-9077-3f79a347d9a7")
	private String description;

}
