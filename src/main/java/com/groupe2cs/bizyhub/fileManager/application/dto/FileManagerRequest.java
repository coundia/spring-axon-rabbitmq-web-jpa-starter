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

	@Schema(description = "", example = "98640e38-efac-4b42-a83d-d668b7ccca4b")
	private String name;
	@Schema(description = "", example = "e47c6855-484d-462d-b7df-d2c03dbcfce9")
	private String details;
	@Schema(description = "", example = "3d2f213d-057b-4268-944f-a6a6eef1f1b7")
	private String objectId;
	@Schema(description = "", example = "188592ff-ec09-41c5-a32c-97cd1e556f5a")
	private String objectName;
	@Schema(description = "", example = "09aae81a-d297-4188-806a-406a4b79f55d")
	private String originalName;
	@Schema(description = "", example = "20b00650-054f-48a8-86ee-e6458b92610b")
	private String mimeType;
	@Schema(description = "", example = "91577L")
	private Long size;
	@Schema(description = "", example = "f78af8b9-4e32-4f80-90d6-012b6afe5fc0")
	private String path;
	@Schema(description = "", example = "c05388ab-7d77-4438-9b2d-0b3e4abeeb6b")
	private String uri;
	@Schema(description = "", example = "true")
	private Boolean isPublic;

}
