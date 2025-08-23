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

	@Schema(description = "", example = "a3c9ae26-e4d0-463d-854b-d161f6a3954b")
	private String name;
	@Schema(description = "", example = "b2c367d5-baa0-4104-9267-dedb4232b676")
	private String details;
	@Schema(description = "", example = "b39f64ea-4a52-46b0-acd3-c11e87523911")
	private String objectId;
	@Schema(description = "", example = "9c314a82-9af7-4bd0-a033-7d5a148d9465")
	private String objectName;
	@Schema(description = "", example = "5723e93e-8215-432f-924a-79a801552c46")
	private String originalName;
	@Schema(description = "", example = "10535479-3b24-4d6e-a03d-d4725513547d")
	private String mimeType;
	@Schema(description = "", example = "71863L")
	private Long size;
	@Schema(description = "", example = "06ba61cb-95c3-4941-affd-ff522f2497a8")
	private String path;
	@Schema(description = "", example = "f71f42d6-f8cb-4721-ba7a-539f40945b19")
	private String uri;
	@Schema(description = "", example = "true")
	private Boolean isPublic;

}
