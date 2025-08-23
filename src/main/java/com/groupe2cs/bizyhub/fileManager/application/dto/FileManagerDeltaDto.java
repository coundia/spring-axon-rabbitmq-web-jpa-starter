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

		@Schema(description = "", example = "c8ba5094-f3c7-4c72-8906-2c0d17484f94")
		private String name;
		@Schema(description = "", example = "8e01b5f1-4287-498b-9c28-9d75421342ca")
		private String details;
		@Schema(description = "", example = "739abf56-6b2d-485e-a7cc-636af9a1d538")
		private String objectId;
		@Schema(description = "", example = "33240283-e575-4995-a602-273ef6f7d441")
		private String objectName;
		@Schema(description = "", example = "2399c89b-50e8-4677-8b17-b3caa410a484")
		private String originalName;
		@Schema(description = "", example = "c9d341ce-19aa-432b-a592-84f907a5ea30")
		private String mimeType;
		@Schema(description = "", example = "66063L")
		private Long size;
		@Schema(description = "", example = "105c868c-4ccd-4883-b7d1-0c9a71c05151")
		private String path;
		@Schema(description = "", example = "0f589737-90ab-41ca-b9b1-92a714318829")
		private String uri;
		@Schema(description = "", example = "false")
		private Boolean isPublic;

}
