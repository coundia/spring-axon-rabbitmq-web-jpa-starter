package com.groupe2cs.bizyhub.sync.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

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

	@Schema(description = "", example = "5dba3e31-647d-454c-a33c-4a5671f7d69d")
	private String entityTable;
	@Schema(description = "", example = "2d2b6360-ee3f-4e9b-846f-f55a322ca1e6")
	private String remoteId;
	@Schema(description = "", example = "04a44f00-b3b6-47af-9890-522a984435ed")
	private String localId;
	@Schema(description = "", example = "4bca746a-45b1-4fd4-b356-547c30a9f780")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant lastSyncAt;
	@Schema(description = "", example = "78e0d39c-ce19-4ce2-9bef-302f4030ca48")
	private String lastCursor;

}
