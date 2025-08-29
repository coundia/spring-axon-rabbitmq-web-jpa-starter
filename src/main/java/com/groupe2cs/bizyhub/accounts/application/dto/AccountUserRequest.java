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

	@Schema(description = "", example = "c11aba62-d81f-4e6c-af08-119626d198f0")
	private String account;
	@Schema(description = "", example = "329ea18d-f669-4831-95cc-a1b95493406f")
	private String user;
	@Schema(description = "", example = "cb90e888-e14f-4b22-a403-e5208ce36346")
	private String identity;
	@Schema(description = "", example = "1491524e-672c-43f8-b229-5e90f024bd42")
	private String phone;
	@Schema(description = "", example = "9c7ffeb7-43bb-49c9-ae91-42b129252352")
	private String email;
	@Schema(description = "", example = "701cfa04-3771-4db3-bbb7-cf4ea41b2125")
	private String role;
	@Schema(description = "", example = "0bf6615a-aef3-42df-9455-a6a4ef17c1b0")
	private String status;
	@Schema(description = "", example = "fe8d37e1-2443-4e55-afda-36c7bc5ca2fa")
	private String invitedBy;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant acceptedAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant revokedAt;
	@Schema(description = "", example = "a7c5333b-c28c-4a62-a02a-0e6aa1da9800")
	private String message;
	@Schema(description = "", example = "1933503f-75cd-44f1-994d-666313043bd2")
	private String remoteId;
	@Schema(description = "", example = "3f966813-278f-4fe7-9018-3cab0107fb4d")
	private String localId;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
