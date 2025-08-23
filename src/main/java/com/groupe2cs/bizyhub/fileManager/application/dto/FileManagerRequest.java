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

	@Schema(description = "", example = "111e33d8-c3c0-442e-bca5-2b1fc39c14e7")
	private String name;
	@Schema(description = "", example = "0cce1acb-8a20-46c3-b9d1-f16447d950c2")
	private String details;
	@Schema(description = "", example = "0b040c5e-c2f1-4f67-ba78-f0fbf396af2c")
	private String objectId;
	@Schema(description = "", example = "ced47c18-d955-4789-8879-c6a8feec9ab5")
	private String objectName;
	@Schema(description = "", example = "3b8d0af8-c63e-4371-896f-0ff81e5f602a")
	private String originalName;
	@Schema(description = "", example = "70e0d57e-f4db-486e-8cc6-58f5547f7ddd")
	private String mimeType;
	@Schema(description = "", example = "65097L")
	private Long size;
	@Schema(description = "", example = "f1d35684-3357-4640-96bf-046225a9e12f")
	private String path;
	@Schema(description = "", example = "2a293bb5-9abf-4bc3-8a71-5f0978cb2836")
	private String uri;
	@Schema(description = "", example = "false")
	private Boolean isPublic;

}
