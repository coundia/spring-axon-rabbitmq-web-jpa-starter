package com.groupe2cs.bizyhub.sales.application.dto;

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
@Schema(name = "SaleDeltaDto", description = "Delta DTO for sale changes")
public class SaleDeltaDto implements Serializable {

    @Schema(description = "Identifier of the sale", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "95129c5a-f9a5-4c58-aeda-9fdb88aaf474")
		private String name;
		@Schema(description = "", example = "4396.1")
		private Double amount;
		@Schema(description = "", example = "a4e27d99-554a-46ba-94ff-792c3f5bf51e")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "dc78c957-dcfa-4298-8e9b-cc8f2feeb89b")
		private String account;
		@Schema(description = "", example = "29a2cd9a-ce96-4dec-a19a-3c45c6ffa004")
		private String category;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "66bbb0a4-f418-4880-ac0a-8fb8ca328aa2")
		private String reference;

}
