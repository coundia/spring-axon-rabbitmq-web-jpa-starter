package com.groupe2cs.bizyhub.accounts.application.dto;

import java.util.List;
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

@Schema(name = "AccountUserSyncRequest", description = "Request payload for synchronizing accountUsers")
public class AccountUserSyncRequest implements Serializable {

@Schema(description = "Batch of accountUser deltas")
private List<AccountUserDeltaDto> deltas;
	}

