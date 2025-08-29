package com.groupe2cs.bizyhub.fileManager.application.dto;

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
@Schema(name = "FileManagerDeltaDto", description = "Delta DTO for fileManager changes")
public class FileManagerDeltaDto implements Serializable {

    @Schema(description = "Identifier of the fileManager", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "432dfb53-738c-4761-a63c-45827833b26d")
		private String name;
		@Schema(description = "", example = "bc3b59d2-462c-48cd-a804-22565dfcf6d8")
		private String details;
		@Schema(description = "", example = "95e68abb-80be-45f0-a16b-9a123b1a5941")
		private String objectId;
		@Schema(description = "", example = "9a06dace-3c1f-416d-b8f8-c66d6cfbcc17")
		private String objectName;
		@Schema(description = "", example = "77468eac-adb4-4726-af3d-90a922a0138b")
		private String originalName;
		@Schema(description = "", example = "4d64d5d6-cf25-455c-8357-b3bb2c77b52f")
		private String mimeType;
		@Schema(description = "", example = "95452L")
		private Long size;
		@Schema(description = "", example = "67ce49c0-bdfc-45f6-8f2f-7cf01b2e0950")
		private String path;
		@Schema(description = "", example = "fce67735-79e7-47c2-822f-f260527448e0")
		private String uri;
		@Schema(description = "", example = "false")
		private Boolean isPublic;

}
