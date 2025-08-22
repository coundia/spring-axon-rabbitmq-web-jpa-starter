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

	@Schema(description = "", example = "e1b0d84c-bccf-4caf-b9c0-a07e226314b6")
	private String name;
	@Schema(description = "", example = "e94da287-58a1-4930-aa3c-2c5b7a3bf25f")
	private String details;
	@Schema(description = "", example = "d96856a1-784a-4075-ac9f-497f9398e54c")
	private String objectId;
	@Schema(description = "", example = "1b2953fa-e558-4d46-92b1-005ee7f8c53d")
	private String objectName;
	@Schema(description = "", example = "f98def34-0c4a-41ea-84b0-89520335221e")
	private String originalName;
	@Schema(description = "", example = "bdd49de0-6fac-4ec8-bf59-97b301ecb12f")
	private String mimeType;
	@Schema(description = "", example = "7398L")
	private Long size;
	@Schema(description = "", example = "0cb66a2e-b616-4c1c-8cac-c1923dff4303")
	private String path;
	@Schema(description = "", example = "ce5fde4c-3aee-4c6b-9e5e-39481144a3a6")
	private String uri;
	@Schema(description = "", example = "false")
	private Boolean isPublic;

}
