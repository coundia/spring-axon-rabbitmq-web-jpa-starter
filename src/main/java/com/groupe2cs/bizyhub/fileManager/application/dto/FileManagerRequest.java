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

	@Schema(description = "", example = "18609f64-33a1-45a4-9c10-4f9b7f917675")
	private String name;
	@Schema(description = "", example = "06c39fe1-197a-45c0-9f91-184125003b92")
	private String details;
	@Schema(description = "", example = "21f5200a-1dcc-46bd-80aa-fc4682fcd69b")
	private String objectId;
	@Schema(description = "", example = "e2fa71c8-85ae-44f5-8e7c-1c8805405ea6")
	private String objectName;
	@Schema(description = "", example = "a37ff5b6-1d3a-4229-8108-d660adaa9a25")
	private String originalName;
	@Schema(description = "", example = "4779f88b-3711-4a7b-9468-1503d1124de0")
	private String mimeType;
	@Schema(description = "", example = "4346L")
	private Long size;
	@Schema(description = "", example = "c14c5da8-d968-4599-9380-9de770ada091")
	private String path;
	@Schema(description = "", example = "593e17c1-13f2-4d6d-98b7-29762c0dfaad")
	private String uri;
	@Schema(description = "", example = "true")
	private Boolean isPublic;

}
