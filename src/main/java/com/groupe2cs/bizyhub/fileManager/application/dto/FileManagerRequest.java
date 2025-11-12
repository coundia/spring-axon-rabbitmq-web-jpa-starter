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

	@Schema(description = "", example = "64d74eff-89fc-462d-9b5d-3ea876c6d2e6")
	private String name;
	@Schema(description = "", example = "6160cfef-a1bc-4a83-a15b-fc37ff60a958")
	private String details;
	@Schema(description = "", example = "76d419dd-f7f5-41d9-8687-97379f3fcbf9")
	private String objectId;
	@Schema(description = "", example = "791cf8d7-7332-4824-84b1-89f4d92ac1aa")
	private String objectName;
	@Schema(description = "", example = "8638eeb1-5644-482f-8371-816ab8ec1f75")
	private String originalName;
	@Schema(description = "", example = "badd41ab-ee1f-41d9-b58f-1ecb7b241b79")
	private String mimeType;
	@Schema(description = "", example = "25039L")
	private Long size;
	@Schema(description = "", example = "b6eed62b-826f-41fd-bef8-fbdf37e25675")
	private String path;
	@Schema(description = "", example = "2cc3a549-4de5-4bcb-939d-ad8942594269")
	private String uri;
	@Schema(description = "", example = "false")
	private Boolean isPublic;

}
