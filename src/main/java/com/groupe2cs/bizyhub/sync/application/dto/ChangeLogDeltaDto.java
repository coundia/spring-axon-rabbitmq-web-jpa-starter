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

		@Schema(description = "", example = "9854128b-d40f-4b91-8042-8f2c069a8976")
		private String entityTable;
		@Schema(description = "", example = "da11ebf9-bf72-400a-a913-0877ae8e0686")
		private String entityId;
		@Schema(description = "", example = "c0f1cf61-9f9c-4463-95e6-6cca3812bb78")
		private String remoteId;
		@Schema(description = "", example = "dbe6c9b4-b0b3-4c89-a116-f30b5ba7966c")
		private String localId;
		@Schema(description = "", example = "ef6a0ce7-5a20-4da6-9ed6-a456a2feea91")
		private String operation;
		@Schema(description = "", example = "fe33d4ab-598d-4df4-a694-9bed383ec7b9")
		private String payload;
		@Schema(description = "", example = "99bdb1f9-1c9e-466e-9007-a2084646f49b")
		private String status;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "63")
		private Integer attempts;
		@Schema(description = "", example = "f9b6dd3d-21ae-4903-8940-6f52fb4a6a30")
		private String error;

}
