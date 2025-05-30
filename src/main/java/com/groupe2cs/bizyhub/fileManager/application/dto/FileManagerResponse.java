package com.groupe2cs.bizyhub.fileManager.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "FileManagerResponse", description = "Response payload for FileManager")
public class FileManagerResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String name;
	@Schema(description = "", example = "")
	private String details;
	@Schema(description = "", example = "")
	private String objectId;
	@Schema(description = "", example = "")
	private String objectName;
	@Schema(description = "", example = "")
	private String originalName;
	@Schema(description = "", example = "")
	private String mimeType;
	@Schema(description = "", example = "")
	private Long size;
	@Schema(description = "", example = "")
	private String path;
	@Schema(description = "", example = "")
	private String uri;
	@Schema(description = "", example = "")
	private Boolean isPublic;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
