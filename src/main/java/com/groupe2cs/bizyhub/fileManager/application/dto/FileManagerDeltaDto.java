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

		@Schema(description = "", example = "337f0399-10eb-4156-8366-63e69d546958")
		private String name;
		@Schema(description = "", example = "6e705925-9172-41c4-b762-285e28c15e88")
		private String details;
		@Schema(description = "", example = "2ca4d421-e019-44d8-a1c1-37d0a9c2184a")
		private String objectId;
		@Schema(description = "", example = "ae634647-1e96-4dcf-92ed-baf36ba1d316")
		private String objectName;
		@Schema(description = "", example = "85eff340-d946-4786-b525-feb5557eef63")
		private String originalName;
		@Schema(description = "", example = "bddf7fe5-2972-4fe8-a5bf-6b370d4dcd50")
		private String mimeType;
		@Schema(description = "", example = "55351L")
		private Long size;
		@Schema(description = "", example = "5bc6fe40-2255-499a-a926-f12ef2ab2b19")
		private String path;
		@Schema(description = "", example = "5e7e87c4-1e56-4465-b834-6060a8777de2")
		private String uri;
		@Schema(description = "", example = "false")
		private Boolean isPublic;

}
