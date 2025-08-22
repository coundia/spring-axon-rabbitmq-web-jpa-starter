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

	@Schema(description = "", example = "a162a404-4ad4-44dd-8658-a1c17afb90ba")
	private String username;
	@Schema(description = "", example = "183fa911-9bb0-4d29-9eac-5721f4932345")
	private String password;
	@Schema(description = "", example = "370bc5eb-547a-49f6-860e-7db3db5b6877")
	private String firstName;
	@Schema(description = "", example = "bdcdd7a5-1147-4780-a24d-807254309ded")
	private String lastName;
	@Schema(description = "", example = "2996dc1d-942d-4e4b-959e-2c706c890612")
	private String email;
	@Schema(description = "", example = "1262ba1a-ef57-449d-9f41-517b20b3f7c6")
	private String telephone;
	@Schema(description = "", example = "62")
	private Integer limitPerDay;
	@Schema(description = "", example = "true")
	private Boolean isPremium;
	@Schema(description = "", example = "false")
	private Boolean enabled;
	@Schema(description = "", example = "true")
	private Boolean isBan;
	@Schema(description = "", example = "7663ccc3-96fb-442f-8c15-d7191fc6c31d")
	private String message;

}
