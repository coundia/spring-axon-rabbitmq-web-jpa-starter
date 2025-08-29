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

	@Schema(description = "", example = "4276a4b5-5abe-4ab3-a298-e9fd72e595bc")
	private String name;
	@Schema(description = "", example = "b48c2061-ee3b-4ac8-9ed6-0b4524c1c46e")
	private String details;
	@Schema(description = "", example = "5a249e28-7e1c-404f-bd5f-f151799170ee")
	private String objectId;
	@Schema(description = "", example = "2060ee47-36b1-4a76-a163-11ac6c6c5cb0")
	private String objectName;
	@Schema(description = "", example = "e32e8837-14be-48be-b5da-f46b077e4567")
	private String originalName;
	@Schema(description = "", example = "f47db819-6bc4-4ebd-abd7-792348330c42")
	private String mimeType;
	@Schema(description = "", example = "95531L")
	private Long size;
	@Schema(description = "", example = "f310f4c7-d7cd-4cb2-85b6-8759fc15df27")
	private String path;
	@Schema(description = "", example = "778b0213-1753-4b30-aedb-2ad5147901ef")
	private String uri;
	@Schema(description = "", example = "true")
	private Boolean isPublic;

}
