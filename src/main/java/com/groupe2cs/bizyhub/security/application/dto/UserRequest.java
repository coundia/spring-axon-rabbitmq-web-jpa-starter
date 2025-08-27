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

	@Schema(description = "", example = "0ae5487d-0bdc-4a1c-b9ba-e3391c9461d7")
	private String username;
	@Schema(description = "", example = "a52c228b-0656-47e4-8298-5fdb1ff0c13e")
	private String password;
	@Schema(description = "", example = "79235d0a-ce6f-44ce-8c7f-2869a7bdf48c")
	private String firstName;
	@Schema(description = "", example = "40645306-bd6c-4476-bf9c-68e91c2c03cd")
	private String lastName;
	@Schema(description = "", example = "2defd378-ccf1-40ce-97b7-0f8f5e3aa862")
	private String email;
	@Schema(description = "", example = "627de406-831e-4f2e-a3d8-42f5990c8d92")
	private String telephone;
	@Schema(description = "", example = "88")
	private Integer limitPerDay;
	@Schema(description = "", example = "false")
	private Boolean isPremium;
	@Schema(description = "", example = "true")
	private Boolean enabled;
	@Schema(description = "", example = "false")
	private Boolean isBan;
	@Schema(description = "", example = "89b983a0-0374-4bdd-952a-ab81582ac584")
	private String message;

}
