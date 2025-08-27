package com.groupe2cs.bizyhub.accounts.application.dto;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
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
@Schema(name = "AccountUserRequest", description = "Request payload for AccountUser operations")
public class AccountUserRequest implements Serializable {

	@Schema(description = "", example = "50706718-be3b-48f6-95a6-35e9c33d07e5")
	private String account;
	@Schema(description = "", example = "fc75125e-eda4-4be1-bbe6-9ad9d4320583")
	private String user;
	@Schema(description = "", example = "59978a86-5265-44a2-94a7-e25121da2d74")
	private String identity;
	@Schema(description = "", example = "843b729f-8dd6-4758-a721-f8d2aab80ec7")
	private String phone;
	@Schema(description = "", example = "72354dc5-ada9-439d-95f8-dcfb6a495194")
	private String email;
	@Schema(description = "", example = "a10ec5c5-2e2c-4ffc-a9eb-ec6e293c3b72")
	private String role;
	@Schema(description = "", example = "297e78c7-383d-4fe8-98da-87a7d7de3f25")
	private String status;
	@Schema(description = "", example = "64cfaa01-c31e-48ac-b0b7-bc0d5360ad2b")
	private String invitedBy;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant acceptedAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant revokedAt;
	@Schema(description = "", example = "9d212891-58f5-47bd-8fcb-308bbb254e43")
	private String message;
	@Schema(description = "", example = "9bf5b581-94e2-47b4-a397-ada4d2d44bc7")
	private String remoteId;
	@Schema(description = "", example = "0de40a6c-15cc-4ea3-8f3a-048c9ad27784")
	private String localId;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
