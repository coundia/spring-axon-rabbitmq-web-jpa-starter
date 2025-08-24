package com.groupe2cs.bizyhub.sync.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "ChangeLogDeltaDto", description = "Delta DTO for changeLog changes")
public class ChangeLogDeltaDto implements Serializable {

    @Schema(description = "Identifier of the changeLog", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "6e1317de-dffa-42f4-bd0f-0d7e32f5a694")
		private String entityTable;
		@Schema(description = "", example = "31616393-6e7e-4371-9e2f-6eef29441167")
		private String entityId;
		@Schema(description = "", example = "ddffab72-5f86-49b8-a472-e4b73ebb89b8")
		private String remoteId;
		@Schema(description = "", example = "199482df-737d-47e8-a0ff-a79acc5daec1")
		private String localId;
		@Schema(description = "", example = "3b1b15d7-9c52-4173-ab83-52399a3fb9ab")
		private String operation;
		@Schema(description = "", example = "8cff1a49-7b99-4e74-a791-34814cafa8d9")
		private String payload;
		@Schema(description = "", example = "23a0e70e-85cb-4ec1-ae30-1d133856d1fd")
		private String status;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "81")
		private Integer attempts;
		@Schema(description = "", example = "b02a36b6-c503-4847-9737-fb16e69f2d16")
		private String error;

}
