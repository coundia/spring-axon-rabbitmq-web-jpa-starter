package com.groupe2cs.bizyhub.fileManager.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "FileManagerRequest", description = "Request payload for FileManager operations")
public class FileManagerRequest implements Serializable {

	@Schema(description = "", example = "71d89d5c-da80-4e32-8088-6a53f6e75fe0")
	private String name;
	@Schema(description = "", example = "6eacc0cf-18e6-418b-bef7-99872df80e39")
	private String details;
	@Schema(description = "", example = "bfcc9179-d217-4a52-b2bb-97e3f42529ca")
	private String objectId;
	@Schema(description = "", example = "1e377b0c-e834-4605-a34e-95a027a47c2f")
	private String objectName;
	@Schema(description = "", example = "1511c929-e965-4985-803d-bf6fe0a97ff6")
	private String originalName;
	@Schema(description = "", example = "6e2c2576-4d6e-415c-8534-2b401b05f2db")
	private String mimeType;
	@Schema(description = "", example = "73239L")
	private Long size;
	@Schema(description = "", example = "a6807d03-b966-4e64-9b46-569c6f00b4bf")
	private String path;
	@Schema(description = "", example = "80f80772-3470-4caa-a9f7-1b51e41a7517")
	private String uri;
	@Schema(description = "", example = "false")
	private Boolean isPublic;

}
