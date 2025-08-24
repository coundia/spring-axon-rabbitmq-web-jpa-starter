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

	@Schema(description = "", example = "1119b86c-bea4-4214-938a-d9b39dec0fa8")
	private String username;
	@Schema(description = "", example = "2adc1872-dba3-4a14-b44b-a69cee346f95")
	private String password;
	@Schema(description = "", example = "9a2caf64-0d8a-4e09-9bba-b653d86e3de3")
	private String firstName;
	@Schema(description = "", example = "1b6c592d-397a-4f77-8464-c4f2b691c130")
	private String lastName;
	@Schema(description = "", example = "33bea2b2-5682-4055-85af-31b9b456806f")
	private String email;
	@Schema(description = "", example = "85768dc9-b7f7-4d00-bbc6-9a858638c77f")
	private String telephone;
	@Schema(description = "", example = "57")
	private Integer limitPerDay;
	@Schema(description = "", example = "true")
	private Boolean isPremium;
	@Schema(description = "", example = "false")
	private Boolean enabled;
	@Schema(description = "", example = "false")
	private Boolean isBan;
	@Schema(description = "", example = "c106b946-3a42-4fbf-a22b-0a38b0212f01")
	private String message;

}
