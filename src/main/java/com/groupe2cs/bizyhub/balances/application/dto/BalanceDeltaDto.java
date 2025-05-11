package com.groupe2cs.bizyhub.balances.application.dto;

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
@Schema(name = "BalanceDeltaDto", description = "Delta DTO for balance changes")
public class BalanceDeltaDto implements Serializable {

    @Schema(description = "Identifier of the balance", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "6629d7b1-90ae-492e-855b-92d5042d5f5f")
		private String name;
		@Schema(description = "", example = "23ea7ae5-56c1-488b-944f-42d1e7233f80")
		private String currency;
		@Schema(description = "", example = "7562.89")
		private Double currentBalance;
		@Schema(description = "", example = "6006.69")
		private Double previousBalance;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant lastUpdated;
		@Schema(description = "", example = "false")
		private Boolean isDefault;
		@Schema(description = "", example = "55")
		private Integer ordre;
		@Schema(description = "", example = "true")
		private Boolean isArchived;
		@Schema(description = "", example = "false")
		private Boolean isAllowDebit;
		@Schema(description = "", example = "false")
		private Boolean isAllowCredit;
		@Schema(description = "", example = "false")
		private Boolean isExcluTotal;
		@Schema(description = "", example = "false")
		private Boolean activateNotification;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncedAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "2f5bb631-0888-4cd2-9d49-307feaa2d6c3")
		private String reference;

}
