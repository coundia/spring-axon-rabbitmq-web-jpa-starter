package com.groupe2cs.bizyhub.accounts.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "AccountDeltaDto", description = "Delta DTO for account changes")
public class AccountDeltaDto implements Serializable {

	@Schema(description = "Identifier of the account", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "66b55cf2-1348-4108-ba0b-cbc19a16390a")
	private String code;
	@Schema(description = "", example = "5a6024ef-3fae-4416-870b-a309934948b6")
	private String name;
	@Schema(description = "", example = "e54171ac-cd28-4e03-8a71-efb9023746f0")
	private String status;
	@Schema(description = "", example = "abc4926b-d631-4870-af5d-d8025fdfbbb8")
	private String currency;
	@Schema(description = "", example = "c43d8c01-3516-4f50-8099-b907a95b8b5a")
	private String typeAccount;
	@Schema(description = "", example = "505.86")
	private Double balance;
	@Schema(description = "", example = "9775.1")
	private Double balancePrev;
	@Schema(description = "", example = "7901.33")
	private Double balanceBlocked;
	@Schema(description = "", example = "6948.96")
	private Double balanceInit;
	@Schema(description = "", example = "7097.81")
	private Double balanceGoal;
	@Schema(description = "", example = "2556.34")
	private Double balanceLimit;
	@Schema(description = "", example = "635fad41-6667-4f9a-adbc-44ae763d062e")
	private String description;
	@Schema(description = "", example = "false")
	private Boolean isActive;
	@Schema(description = "", example = "false")
	private Boolean isDefault;
	@Schema(description = "", example = "a9fd0244-5528-4359-b325-6d2f780d4964")
	private String remoteId;
	@Schema(description = "", example = "16c4b93e-d7d4-4c49-a428-5780452c83f5")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
