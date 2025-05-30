package com.groupe2cs.bizyhub.fileManager.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "FileManagerDeltaDto", description = "Delta DTO for fileManager changes")
public class FileManagerDeltaDto implements Serializable {

	@Schema(description = "Identifier of the fileManager", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "8c8b94e7-d1c7-4d2f-916b-c10e87852e49")
	private String name;
	@Schema(description = "", example = "f9ba3841-cc44-4801-bcde-60710f9e62d7")
	private String details;
	@Schema(description = "", example = "03b7bfc7-6c94-4298-b775-81a547421c80")
	private String objectId;
	@Schema(description = "", example = "682a549b-6efd-492c-af26-2cc673eb79c2")
	private String objectName;
	@Schema(description = "", example = "c08277b8-a090-46e8-89c7-76f8eb744876")
	private String originalName;
	@Schema(description = "", example = "2615dc4c-2ac1-42c4-a5a3-fcb49bb8aefb")
	private String mimeType;
	@Schema(description = "", example = "75656L")
	private Long size;
	@Schema(description = "", example = "d20956ac-7125-4f0a-bfc7-80b41b5bee80")
	private String path;
	@Schema(description = "", example = "3204435f-2f93-424d-9481-1a02c23e8e3e")
	private String uri;
	@Schema(description = "", example = "true")
	private Boolean isPublic;

}
