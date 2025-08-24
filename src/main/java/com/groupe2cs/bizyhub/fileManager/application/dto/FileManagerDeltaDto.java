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

		@Schema(description = "", example = "ad1a4cdf-b031-4327-9a7b-363e9dc0014f")
		private String name;
		@Schema(description = "", example = "6c13eb1a-8deb-490a-9513-72ef92b18119")
		private String details;
		@Schema(description = "", example = "3b1c5357-f369-4699-ac6c-8e49ac47cb0d")
		private String objectId;
		@Schema(description = "", example = "adcbbc5d-09b2-4d6f-a1e6-e097237dcd62")
		private String objectName;
		@Schema(description = "", example = "58d09c11-001d-4123-b884-0b5154e97946")
		private String originalName;
		@Schema(description = "", example = "29c1e692-8be7-472a-a284-be4e6281473e")
		private String mimeType;
		@Schema(description = "", example = "51813L")
		private Long size;
		@Schema(description = "", example = "20fa24fd-eba2-4096-928e-af1194e589aa")
		private String path;
		@Schema(description = "", example = "5ec9c295-8a5f-44ca-a68a-c95cbaa3f51f")
		private String uri;
		@Schema(description = "", example = "true")
		private Boolean isPublic;

}
