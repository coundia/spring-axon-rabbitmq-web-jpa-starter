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

		@Schema(description = "", example = "c59c1600-0e0d-4d11-8c05-23b83de65034")
		private String entityTable;
		@Schema(description = "", example = "10e0db17-d4d7-4dd4-9a32-6d53ab2db58d")
		private String entityId;
		@Schema(description = "", example = "9218f7cf-6841-46af-bcd0-d595187ff1dd")
		private String remoteId;
		@Schema(description = "", example = "bab3d3c7-c273-48e1-8a87-e73b87f66d47")
		private String localId;
		@Schema(description = "", example = "8f6119fa-b88d-4843-9329-9346560cdd69")
		private String operation;
		@Schema(description = "", example = "6f4f1026-3fa5-416d-922d-c62aa1c74d6e")
		private String payload;
		@Schema(description = "", example = "eb813512-06a1-43d0-969b-aa2e4e8085e0")
		private String status;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "69")
		private Integer attempts;
		@Schema(description = "", example = "f19cab72-a2cc-4782-a967-622f1d7a6b24")
		private String error;

}
