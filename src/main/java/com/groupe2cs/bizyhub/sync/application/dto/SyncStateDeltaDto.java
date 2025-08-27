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

		@Schema(description = "", example = "5e155992-868f-4744-bd48-69aba4ba0c02")
		private String entityTable;
		@Schema(description = "", example = "ef0cce2b-8a29-4e25-91e2-8808e60ceb27")
		private String remoteId;
		@Schema(description = "", example = "7a99d04b-bf4b-4a73-acf6-42db83c638ee")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant lastSyncAt;
		@Schema(description = "", example = "d8aeb542-c6bb-44a2-8637-04b29fb380a1")
		private String lastCursor;

}
