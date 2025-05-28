package com.groupe2cs.bizyhub.security.application.dto;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
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
@Schema(name = "UserRequest", description = "Request payload for User operations")
public class UserRequest implements Serializable {

	@Schema(description = "", example = "f6a592a2-84a5-4bd8-8c31-8c7b85c53a78")
	private String username;
	@Schema(description = "", example = "fc7a98a2-cb13-490d-b00d-e3b451f186c7")
	private String password;
	@Schema(description = "", example = "6ba90c7b-424e-40e0-bde5-5ed5de66afc2")
	private String firstName;
	@Schema(description = "", example = "92e71eb6-be61-4717-810e-1b9f235f5a54")
	private String lastName;
	@Schema(description = "", example = "a42748f2-a1b5-4c18-a297-585cdae58e51")
	private String email;
	@Schema(description = "", example = "7905a0be-9014-4ba4-8563-1087d9dc352a")
	private String telephone;
	@Schema(description = "", example = "32")
	private Integer limitPerDay;
	@Schema(description = "", example = "true")
	private Boolean isPremium;
	@Schema(description = "", example = "true")
	private Boolean enabled;
	@Schema(description = "", example = "false")
	private Boolean isBan;
	@Schema(description = "", example = "e0dc3d19-576b-4534-b21c-a644ef1f43f0")
	private String message;

}
