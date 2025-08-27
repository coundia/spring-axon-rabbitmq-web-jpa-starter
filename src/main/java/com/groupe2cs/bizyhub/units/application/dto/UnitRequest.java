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

	@Schema(description = "", example = "6063b22c-fc64-47cf-876d-d5ad300ccaaf")
	private String remoteId;
	@Schema(description = "", example = "fa50cb63-1e4b-4a9d-be66-4380121a2911")
	private String localId;
	@Schema(description = "", example = "ca9625b9-74db-4f4a-b16b-8c1c22ff076a")
	private String code;
	@Schema(description = "", example = "d2532c3b-94dd-4329-809c-2cfef44e2370")
	private String name;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "3069ad3e-5444-47da-8079-f84d55a46985")
	private String description;

}
