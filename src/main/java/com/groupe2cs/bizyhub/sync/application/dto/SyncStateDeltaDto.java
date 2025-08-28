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

		@Schema(description = "", example = "843e8992-308b-4d54-b346-51207cd53d63")
		private String entityTable;
		@Schema(description = "", example = "5c1fda90-5bde-42c7-a5ea-cf14eda5d2e4")
		private String remoteId;
		@Schema(description = "", example = "0b17f374-6c6d-485f-bc05-1f113bbc864e")
		private String localId;
		@Schema(description = "", example = "87f5ffaa-161b-4002-8cab-16599cdcfecf")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant lastSyncAt;
		@Schema(description = "", example = "2e7fc463-30cb-4859-a4ff-850bf852d4e4")
		private String lastCursor;

}
