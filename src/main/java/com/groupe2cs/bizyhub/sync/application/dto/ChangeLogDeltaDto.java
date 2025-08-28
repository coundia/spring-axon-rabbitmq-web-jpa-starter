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

		@Schema(description = "", example = "a333976b-f3f2-4852-aa55-d4b5c849663a")
		private String entityTable;
		@Schema(description = "", example = "359c4fb6-5fc2-4b48-bda4-0cadd376fa66")
		private String account;
		@Schema(description = "", example = "2a1c3546-02ec-4fde-a5b5-9f18c34986f0")
		private String remoteId;
		@Schema(description = "", example = "ec7c90fc-c969-4488-9b40-2bd1bc3855a5")
		private String localId;
		@Schema(description = "", example = "0d706e00-0603-448c-997a-54cf735bc591")
		private String operation;
		@Schema(description = "", example = "9617c64c-9e70-4d3a-a6b9-2729be99ff88")
		private String payload;
		@Schema(description = "", example = "cb5da588-2ad4-4528-8ce5-06309e396fde")
		private String status;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "21")
		private Integer attempts;
		@Schema(description = "", example = "b94a2632-cbff-4ab8-8cb3-fb04b3f93750")
		private String error;

}
