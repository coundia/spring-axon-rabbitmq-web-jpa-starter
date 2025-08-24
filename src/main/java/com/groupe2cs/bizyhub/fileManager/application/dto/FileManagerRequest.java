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

	@Schema(description = "", example = "0abd0472-ca2d-4c14-81f3-cac27afa2d8a")
	private String name;
	@Schema(description = "", example = "bf28ecf6-802b-4400-8051-9ca0e5b0fea0")
	private String details;
	@Schema(description = "", example = "21b48042-07cc-4cc0-b796-b4c7e50c7b1a")
	private String objectId;
	@Schema(description = "", example = "6d4f0a96-cba6-4da6-b64a-dcef21673e0d")
	private String objectName;
	@Schema(description = "", example = "dfaeeb85-74f8-43f2-b84d-d00a3c928f58")
	private String originalName;
	@Schema(description = "", example = "86dba059-6e09-401a-be5e-01f39ca4e231")
	private String mimeType;
	@Schema(description = "", example = "61930L")
	private Long size;
	@Schema(description = "", example = "276a3cff-7f2f-47fe-a8a8-3dc11dc513a5")
	private String path;
	@Schema(description = "", example = "990a7a47-bb19-44d5-b99c-b2ed22395021")
	private String uri;
	@Schema(description = "", example = "false")
	private Boolean isPublic;

}
