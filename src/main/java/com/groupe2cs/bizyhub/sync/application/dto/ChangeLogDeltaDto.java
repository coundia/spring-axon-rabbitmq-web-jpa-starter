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

		@Schema(description = "", example = "b05ac4cc-5ce5-4298-96b0-723fa357cb3a")
		private String entityTable;
		@Schema(description = "", example = "ba19a939-fd66-4999-9b26-2dd9b39ad79d")
		private String entityId;
		@Schema(description = "", example = "d8e54c5a-b031-4bcb-ba4c-0e28fc8e62a0")
		private String operation;
		@Schema(description = "", example = "ecdc0a0c-3403-4c28-bbe6-8209faed4a48")
		private String payload;
		@Schema(description = "", example = "9d4580ad-7a3a-4526-b1cb-21d9655cc19e")
		private String status;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "40")
		private Integer attempts;
		@Schema(description = "", example = "46f6fb0f-3163-4cf6-8366-046764e02189")
		private String error;

}
