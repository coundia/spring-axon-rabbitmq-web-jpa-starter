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
@Schema(name = "ChangeLogDeltaDto", description = "Delta DTO for changeLog changes")
public class ChangeLogDeltaDto implements Serializable {

	@Schema(description = "Identifier of the changeLog", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "e9c02b8b-b1bc-4829-8307-c66484d30db8")
	private String entityTable;
	@Schema(description = "", example = "8ebd22e6-5712-4dc8-a76c-4ade4c7d2a5a")
	private String account;
	@Schema(description = "", example = "5383188a-094a-4fad-9afe-601ee65efafd")
	private String remoteId;
	@Schema(description = "", example = "dee3392e-0489-430f-a157-69a9228494fe")
	private String localId;
	@Schema(description = "", example = "1dbc60a2-a639-4bd2-a000-db32931e6a4c")
	private String operation;
	@Schema(description = "", example = "26d5004a-7a44-466a-993c-05a03d6d761b")
	private String payload;
	@Schema(description = "", example = "263aaddb-e9a9-4625-a595-0d756707ecef")
	private String status;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "85")
	private Integer attempts;
	@Schema(description = "", example = "ff960472-3f2d-4015-aa1f-b0ecf8b7f805")
	private String error;

}
