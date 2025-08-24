package com.groupe2cs.bizyhub.fileManager.application.dto;

import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;
import java.util.UUID;
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
@Schema(name = "FileManagerRequest", description = "Request payload for FileManager operations")
public class FileManagerRequest implements Serializable {

	@Schema(description = "", example = "7dd524ef-f20f-441d-b836-29ec5b321136")
	private String name;
	@Schema(description = "", example = "ebce774c-7f20-4fce-8459-12b3f8d873dc")
	private String details;
	@Schema(description = "", example = "de8713f5-7c8e-4114-bc9a-21025f39790c")
	private String objectId;
	@Schema(description = "", example = "1f499922-e6b6-4381-aa7a-f0b81bab2d56")
	private String objectName;
	@Schema(description = "", example = "be9c0837-64ce-4e2e-abea-d9fc227b1aa4")
	private String originalName;
	@Schema(description = "", example = "921c7c9a-85d5-421d-962e-adbecee4b980")
	private String mimeType;
	@Schema(description = "", example = "57266L")
	private Long size;
	@Schema(description = "", example = "95887b6c-3e40-4ac9-a460-ec1fb50fe046")
	private String path;
	@Schema(description = "", example = "9e754aad-710e-4b1f-a37f-007f5026544f")
	private String uri;
	@Schema(description = "", example = "false")
	private Boolean isPublic;

}
