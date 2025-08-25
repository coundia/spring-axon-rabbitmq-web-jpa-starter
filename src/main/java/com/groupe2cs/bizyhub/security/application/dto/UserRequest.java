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

	@Schema(description = "", example = "8f0d405e-24d8-4f0e-99df-802aa6c4162a")
	private String username;
	@Schema(description = "", example = "518c3279-836a-4eb0-b9d7-c372a53c1917")
	private String password;
	@Schema(description = "", example = "9e80cdbb-d9fa-42dd-8bc9-932e9f1d63c5")
	private String firstName;
	@Schema(description = "", example = "90632205-875f-4760-837c-60c56b16e013")
	private String lastName;
	@Schema(description = "", example = "2c6f1959-c65b-49c3-a478-7cc419be749a")
	private String email;
	@Schema(description = "", example = "84fd2fa5-6c1b-410c-ad3a-fe0dc014890a")
	private String telephone;
	@Schema(description = "", example = "96")
	private Integer limitPerDay;
	@Schema(description = "", example = "true")
	private Boolean isPremium;
	@Schema(description = "", example = "true")
	private Boolean enabled;
	@Schema(description = "", example = "true")
	private Boolean isBan;
	@Schema(description = "", example = "282ec121-4141-4dfd-b500-29dc5aa221d1")
	private String message;

}
