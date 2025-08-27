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

		@Schema(description = "", example = "d7474f98-e948-4352-aef2-e49c184b0220")
		private String name;
		@Schema(description = "", example = "b0759579-300c-4032-ae64-6df5212fa62f")
		private String details;
		@Schema(description = "", example = "602a9c73-75c1-4bd7-b5f7-f439c76c3e4c")
		private String objectId;
		@Schema(description = "", example = "7ce804cc-939c-47ad-ac61-ae9a9b1b817a")
		private String objectName;
		@Schema(description = "", example = "21a10213-e563-43c5-957f-9ac4eccad9e1")
		private String originalName;
		@Schema(description = "", example = "0beef19b-bbe3-40f1-8cd3-cfdcc7788409")
		private String mimeType;
		@Schema(description = "", example = "16354L")
		private Long size;
		@Schema(description = "", example = "22b863e4-2885-4536-9e54-4f8e19f21077")
		private String path;
		@Schema(description = "", example = "e1557981-f15b-448a-8cbb-987ed220c8f1")
		private String uri;
		@Schema(description = "", example = "false")
		private Boolean isPublic;

}
