package com.groupe2cs.bizyhub.categories.application.dto;

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
@Schema(name = "CategoryDeltaDto", description = "Delta DTO for category changes")
public class CategoryDeltaDto implements Serializable {

    @Schema(description = "Identifier of the category", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "5dd01427-47a7-4d67-9e36-e951d82eb12b")
		private String code;
		@Schema(description = "", example = "bf0774b7-45a2-47a5-ad28-6e7bb454a54c")
		private String name;
		@Schema(description = "", example = "e58fdd7e-9475-4a79-9339-8761a9661160")
		private String remoteId;
		@Schema(description = "", example = "74ebed72-a28e-462a-a619-68a57a1ccbbc")
		private String description;
		@Schema(description = "", example = "6c5d6c00-0e79-4559-9bb0-eccf48659ab6")
		private String typeEntry;
		@Schema(description = "", example = "7")
		private Integer version;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
