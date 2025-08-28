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

	@Schema(description = "", example = "51b5b341-015c-4ef4-acca-3221d526878b")
	private String username;
	@Schema(description = "", example = "e6d21f31-144a-475c-ae8d-abe4c42f73dc")
	private String password;
	@Schema(description = "", example = "d9a51222-db9d-4e63-9c14-1ea312eb3f54")
	private String firstName;
	@Schema(description = "", example = "91edce7e-7f35-4133-8f23-586244a1cecf")
	private String lastName;
	@Schema(description = "", example = "ac8222a6-3a1d-48cb-bcc5-4286128e699b")
	private String email;
	@Schema(description = "", example = "f9809e79-6d0c-4989-a856-f3818e07cca4")
	private String telephone;
	@Schema(description = "", example = "2")
	private Integer limitPerDay;
	@Schema(description = "", example = "true")
	private Boolean isPremium;
	@Schema(description = "", example = "true")
	private Boolean enabled;
	@Schema(description = "", example = "true")
	private Boolean isBan;
	@Schema(description = "", example = "85cef99e-f9d0-474e-8334-e30c8d5d00ef")
	private String message;

}
