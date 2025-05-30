package com.groupe2cs.bizyhub.accounts.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "AccountSyncRequest", description = "Request payload for synchronizing accounts")
public class AccountSyncRequest implements Serializable {

	@Schema(description = "Batch of account deltas")
	private List<AccountDeltaDto> deltas;
}

