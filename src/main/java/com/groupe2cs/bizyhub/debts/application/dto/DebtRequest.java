package com.groupe2cs.bizyhub.debts.application.dto;

import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
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
@Schema(name = "DebtRequest", description = "Request payload for Debt operations")
public class DebtRequest implements Serializable {

	@Schema(description = "", example = "23cf7c5e-d7d8-4f48-935d-5b9d6a4e25f7")
	private String remoteId;
	@Schema(description = "", example = "7bb7256d-f5e6-46ad-b888-c1e6a53fbc5d")
	private String localId;
	@Schema(description = "", example = "fb056e0c-05bf-4d8d-83cf-b7a98e267cd0")
	private String code;
	@Schema(description = "", example = "c0afbed9-48bc-41e3-978d-fb4ac80cb61d")
	private String notes;
	@Schema(description = "", example = "9591.2")
	private Double balance;
	@Schema(description = "", example = "5195.38")
	private Double balanceDebt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dueDate;
	@Schema(description = "", example = "19e337f9-18ab-472a-b277-c420c85f1e33")
	private String statuses;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "ec087235-f558-4a90-b17f-31327772c4c7")
	private String customer;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
