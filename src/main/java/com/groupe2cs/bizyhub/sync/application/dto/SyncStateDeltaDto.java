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
@Schema(name = "SyncStateDeltaDto", description = "Delta DTO for syncState changes")
public class SyncStateDeltaDto implements Serializable {

    @Schema(description = "Identifier of the syncState", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "d3e52ad1-06d0-4139-bf50-b44bcb0bab8c")
		private String entityTable;
		@Schema(description = "", example = "b3bfa170-15cf-4cc0-86b9-3b350b3ce57e")
		private String remoteId;
		@Schema(description = "", example = "599cbc47-cba5-43cd-9bae-0707454705b0")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant lastSyncAt;
		@Schema(description = "", example = "0316be96-2c01-4aeb-b011-20e30d2bf04d")
		private String lastCursor;

}
