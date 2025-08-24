package com.groupe2cs.bizyhub.fileManager.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "FileManagerDeltaDto", description = "Delta DTO for fileManager changes")
public class FileManagerDeltaDto implements Serializable {

    @Schema(description = "Identifier of the fileManager", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "25b14c16-c2be-415f-88ac-780ea5d85b99")
		private String name;
		@Schema(description = "", example = "13eba5d1-e43b-4b5b-9c7b-f57945414791")
		private String details;
		@Schema(description = "", example = "d367e36d-3497-4514-b92f-32b402cabadf")
		private String objectId;
		@Schema(description = "", example = "7d554af9-78d7-433f-ab2a-53a880438260")
		private String objectName;
		@Schema(description = "", example = "0ffaa90d-2973-4755-9dbe-7605de8a2079")
		private String originalName;
		@Schema(description = "", example = "a89a5b1c-5d81-47bd-84e7-5ac4ca205396")
		private String mimeType;
		@Schema(description = "", example = "64185L")
		private Long size;
		@Schema(description = "", example = "b43907fa-1952-40fa-89d7-fb0b1b8b6852")
		private String path;
		@Schema(description = "", example = "8a807e54-f824-4653-8018-a5eb83226f25")
		private String uri;
		@Schema(description = "", example = "true")
		private Boolean isPublic;

}
