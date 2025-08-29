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

@Schema(name = "AccountUserSyncRequest", description = "Request payload for synchronizing accountUsers")
public class AccountUserSyncRequest implements Serializable {

	@Schema(description = "Batch of accountUser deltas")
	private List<AccountUserDeltaDto> deltas;
}

