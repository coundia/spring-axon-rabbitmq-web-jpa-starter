package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "UserRequest", description = "Request payload for User operations")
public class UserRequest implements Serializable {

	@Schema(description = "", example = "461ee8bd-c5e4-462d-b455-15f9ffdc0aff")
	private String username;
	@Schema(description = "", example = "65638279-e253-43ef-9f3e-316a1238e9b0")
	private String password;
	@Schema(description = "", example = "db586fd6-5901-4819-98a5-414abe482ec5")
	private String firstName;
	@Schema(description = "", example = "1e7467bf-7e5a-49da-92bc-64ca19da311c")
	private String lastName;
	@Schema(description = "", example = "efa3b94b-7643-4370-a46a-d27ac29d12f6")
	private String email;
	@Schema(description = "", example = "87553683-7f43-42e0-a66e-b12f93397547")
	private String telephone;
	@Schema(description = "", example = "16")
	private Integer limitPerDay;
	@Schema(description = "", example = "true")
	private Boolean isPremium;
	@Schema(description = "", example = "true")
	private Boolean enabled;
	@Schema(description = "", example = "true")
	private Boolean isBan;
	@Schema(description = "", example = "2f5960c9-f703-415d-8896-d8ade75db1a7")
	private String message;

}
