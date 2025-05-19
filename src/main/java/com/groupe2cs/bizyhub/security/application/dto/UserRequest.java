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

	@Schema(description = "", example = "2201481e-c3e7-4d2a-ac53-7fa851402e6f")
	private String username;

	@Schema(description = "", example = "011ee4ee-b444-4468-800b-ee673485b4a2")
	private String password;

	@Schema(description = "", example = "7ee1c4ad-ae76-479e-8521-5d804a2b0fc3")
	private String firstName;

	@Schema(description = "", example = "c74297a4-3bc6-44ee-a00b-89b031a559fc")
	private String lastName;

	@Schema(description = "", example = "a1afd9b2-8e8b-4809-93b3-9c8325882abb")
	private String email;

	@Schema(description = "", example = "aa7500be-8dc2-442f-8a44-266d683a482b")
	private String telephone;

	@Schema(description = "", example = "49")
	private Integer limitPerDay;

	@Schema(description = "", example = "true")
	private Boolean isPremium;

	@Schema(description = "", example = "true")
	private Boolean enabled;

	@Schema(description = "", example = "true")
	private Boolean isBan;


}
