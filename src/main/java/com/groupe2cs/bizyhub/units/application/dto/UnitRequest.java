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

	@Schema(description = "", example = "d25548f4-b818-4cf4-9157-78521d2bdfa2")
	private String remoteId;
	@Schema(description = "", example = "9db2fd4c-b3e8-40ed-b121-e59d47439f6c")
	private String localId;
	@Schema(description = "", example = "a87a527f-7403-4585-b843-984e8f86b3e8")
	private String code;
	@Schema(description = "", example = "63f84606-3c75-4847-a18f-506e347b0776")
	private String name;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "9da13949-bfdf-4646-8dd3-4724fdd16a5e")
	private String description;

}
