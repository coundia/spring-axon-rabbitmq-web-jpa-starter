package com.groupe2cs.bizyhub.balances.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

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

	@Schema(description = "", example = "26de8dbe-41f5-4804-93cc-21b64e22630b")
	private String name;
	@Schema(description = "", example = "78bd66fc-f98d-45a1-b328-5c0c653977a7")
	private String currency;
	@Schema(description = "", example = "463.44")
	private Double currentBalance;
	@Schema(description = "", example = "592.53")
	private Double previousBalance;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant lastUpdated;
	@Schema(description = "", example = "true")
	private Boolean isDefault;
	@Schema(description = "", example = "54")
	private Integer ordre;
	@Schema(description = "", example = "true")
	private Boolean isArchived;
	@Schema(description = "", example = "true")
	private Boolean isAllowDebit;
	@Schema(description = "", example = "true")
	private Boolean isAllowCredit;
	@Schema(description = "", example = "true")
	private Boolean isExcluTotal;
	@Schema(description = "", example = "false")
	private Boolean activateNotification;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncedAt;

}
