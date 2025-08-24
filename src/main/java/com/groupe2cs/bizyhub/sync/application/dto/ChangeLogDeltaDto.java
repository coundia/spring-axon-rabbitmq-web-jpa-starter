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

		@Schema(description = "", example = "fe346f3e-515f-4fe3-9f9e-fc4ef6712456")
		private String entityTable;
		@Schema(description = "", example = "d8335ecd-f976-4f7d-acb9-9b2d99291040")
		private String entityId;
		@Schema(description = "", example = "472356cb-7243-4729-a80f-003f2638a12a")
		private String remoteId;
		@Schema(description = "", example = "ee531ebb-068f-42fe-8543-6fb7bcae2981")
		private String operation;
		@Schema(description = "", example = "572917d8-f567-49cf-aa38-9229335fb33c")
		private String payload;
		@Schema(description = "", example = "57f36d26-b93e-46fa-9627-c1bd89d3ad62")
		private String status;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "7")
		private Integer attempts;
		@Schema(description = "", example = "acd5f3ce-75ad-499a-8b81-42075986d8ad")
		private String error;

}
