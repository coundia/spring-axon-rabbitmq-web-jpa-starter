package com.groupe2cs.bizyhub.sync.application.dto;

import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
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
@Schema(name = "ChangeLogRequest", description = "Request payload for ChangeLog operations")
public class ChangeLogRequest implements Serializable {

	@Schema(description = "", example = "9116d3df-150e-4953-8e7e-2d30d1c972e2")
	private String entityTable;
	@Schema(description = "", example = "4c6f9173-04be-4ee7-81a8-bfdda6faacf7")
	private String entityId;
	@Schema(description = "", example = "07dd408a-324d-475c-817a-d17a506ccffb")
	private String operation;
	@Schema(description = "", example = "6da08415-3398-47ae-a388-bb660c64e7ab")
	private String payload;
	@Schema(description = "", example = "2a7acc94-e229-4ac1-8467-ec38833aa779")
	private String status;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "69")
	private Integer attempts;
	@Schema(description = "", example = "5fb3be0e-99c2-4b24-b9ff-f68d6e435e56")
	private String error;

}
