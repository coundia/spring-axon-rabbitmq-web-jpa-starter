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

	@Schema(description = "", example = "1450764c-41ec-4e78-83c4-ccad0dd8fc01")
	private String name;
	@Schema(description = "", example = "094d5eab-07c9-4a1b-a4eb-94d8aa9b78ea")
	private String details;
	@Schema(description = "", example = "80546da8-8e12-4ae8-80cf-a10a42a9c94d")
	private String objectId;
	@Schema(description = "", example = "5e5f383d-c9e8-4e23-8007-22c1ba2fa2fc")
	private String objectName;
	@Schema(description = "", example = "ec6e7ead-7368-4794-b158-aa2e03d903f3")
	private String originalName;
	@Schema(description = "", example = "303f84a9-7f06-425f-a37b-bdc225e78311")
	private String mimeType;
	@Schema(description = "", example = "41750L")
	private Long size;
	@Schema(description = "", example = "0d377280-24cb-440a-9dfd-5e50a20e905c")
	private String path;
	@Schema(description = "", example = "b10fee2f-24ab-4558-80ba-4d4998dfc02f")
	private String uri;
	@Schema(description = "", example = "false")
	private Boolean isPublic;

}
