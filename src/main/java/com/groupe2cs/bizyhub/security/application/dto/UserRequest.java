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

	@Schema(description = "", example = "695e2cd5-7c7b-45f1-a240-5ed968847e1c")
	private String username;
	@Schema(description = "", example = "e1b3f043-ed1c-49d9-a328-babf7582c32e")
	private String password;
	@Schema(description = "", example = "1d9004d0-1472-484c-911e-914961975968")
	private String firstName;
	@Schema(description = "", example = "735194c1-9a51-4478-af49-32fde52ad8bd")
	private String lastName;
	@Schema(description = "", example = "2f6f185d-62b2-4ed3-b1e7-a7a31bda83e5")
	private String email;
	@Schema(description = "", example = "71d5208c-0be0-4e9a-a6a3-ab8d7dc15ea4")
	private String telephone;
	@Schema(description = "", example = "31")
	private Integer limitPerDay;
	@Schema(description = "", example = "false")
	private Boolean isPremium;
	@Schema(description = "", example = "false")
	private Boolean enabled;
	@Schema(description = "", example = "false")
	private Boolean isBan;
	@Schema(description = "", example = "3c3c6ef1-37a4-47a6-8f5a-6fe6a1668294")
	private String message;

}
