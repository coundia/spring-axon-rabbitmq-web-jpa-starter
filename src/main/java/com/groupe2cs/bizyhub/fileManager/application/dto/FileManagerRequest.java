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

	@Schema(description = "", example = "c21bc77e-d636-4721-9fe1-383604ec1de0")
	private String name;
	@Schema(description = "", example = "fa249343-455d-4774-a75d-e42e95b67c03")
	private String details;
	@Schema(description = "", example = "15bb02f7-2f16-4aa7-8780-b17bc8df09a0")
	private String objectId;
	@Schema(description = "", example = "f0f11b22-1500-45c5-b40a-92bd7170a7a1")
	private String objectName;
	@Schema(description = "", example = "fd6410fa-f6ea-453b-811f-a3ba7aabc3f8")
	private String originalName;
	@Schema(description = "", example = "3faca5c8-5300-4b78-aa1f-cfeefe1184d2")
	private String mimeType;
	@Schema(description = "", example = "86720L")
	private Long size;
	@Schema(description = "", example = "ca721465-592f-4484-a99c-422e96f2d922")
	private String path;
	@Schema(description = "", example = "f03f4ec9-33b5-440d-a966-ddf83848a7c4")
	private String uri;
	@Schema(description = "", example = "false")
	private Boolean isPublic;

}
