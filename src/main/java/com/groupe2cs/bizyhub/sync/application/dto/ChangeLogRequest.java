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

	@Schema(description = "", example = "a86b6678-5bfe-4ef9-aaa9-e5d9510b62a8")
	private String entityTable;
	@Schema(description = "", example = "98d08a4e-ab80-45bf-8e7b-043f09b20794")
	private String account;
	@Schema(description = "", example = "8fd71806-1710-4c0c-9d9c-658b77b75940")
	private String remoteId;
	@Schema(description = "", example = "119d9e68-b088-4330-ba8a-c9391d5bbbcd")
	private String localId;
	@Schema(description = "", example = "042f1dab-f6b7-42b0-88ba-7910195b14b3")
	private String operation;
	@Schema(description = "", example = "b9210c61-da52-454b-8e2a-4547e276c284")
	private String payload;
	@Schema(description = "", example = "f302b479-e263-4a78-aa59-62260aad5031")
	private String status;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "66")
	private Integer attempts;
	@Schema(description = "", example = "c2f11ffe-7594-4de0-a6b3-8aa4767f3654")
	private String error;

}
