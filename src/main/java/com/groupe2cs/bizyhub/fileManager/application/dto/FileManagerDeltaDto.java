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

		@Schema(description = "", example = "8dabd165-c481-400f-9070-7644b2087a86")
		private String name;
		@Schema(description = "", example = "48658689-b14f-44fe-89ee-998519f3629f")
		private String details;
		@Schema(description = "", example = "4b6b41ce-f507-4274-9e9b-8d3713d638d1")
		private String objectId;
		@Schema(description = "", example = "9edcde9e-b6d8-46f2-9326-909a6786678d")
		private String objectName;
		@Schema(description = "", example = "598b2aee-48da-4a80-a2fa-01b6dd8afe0f")
		private String originalName;
		@Schema(description = "", example = "3889e15f-42c1-4632-a2b0-eeea429e7650")
		private String mimeType;
		@Schema(description = "", example = "51864L")
		private Long size;
		@Schema(description = "", example = "aca80e50-0765-4909-87ed-43b47f72f46c")
		private String path;
		@Schema(description = "", example = "fdd0dbd1-000f-4283-b4c0-ca1dcd9046a3")
		private String uri;
		@Schema(description = "", example = "false")
		private Boolean isPublic;

}
