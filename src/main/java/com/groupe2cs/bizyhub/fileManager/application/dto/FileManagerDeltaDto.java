package com.groupe2cs.bizyhub.fileManager.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "FileManagerDeltaDto", description = "Delta DTO for fileManager changes")
public class FileManagerDeltaDto implements Serializable {

    @Schema(description = "Identifier of the fileManager", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "96f9a58b-4e95-42ac-ba39-50749f061ef4")
		private String name;
		@Schema(description = "", example = "60da64b9-00cd-4991-9ebc-c1adaded9bde")
		private String details;
		@Schema(description = "", example = "1b8ab358-f1f6-4250-82c9-1c05f5729ddb")
		private String objectId;
		@Schema(description = "", example = "0196c530-2614-40c6-823b-44d7729372da")
		private String objectName;
		@Schema(description = "", example = "f3c1e9da-d235-453d-a006-491064a8cead")
		private String originalName;
		@Schema(description = "", example = "55472171-04a1-4ab8-8db6-c86495b178a5")
		private String mimeType;
		@Schema(description = "", example = "97839L")
		private Long size;
		@Schema(description = "", example = "c60da23a-43ea-4228-b1c4-3de289920d81")
		private String path;
		@Schema(description = "", example = "c6238901-416d-45b5-b350-9e664f83a5e5")
		private String uri;
		@Schema(description = "", example = "false")
		private Boolean isPublic;

}
