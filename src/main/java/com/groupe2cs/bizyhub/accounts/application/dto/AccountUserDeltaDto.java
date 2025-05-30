package com.groupe2cs.bizyhub.accounts.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "AccountUserDeltaDto", description = "Delta DTO for accountUser changes")
public class AccountUserDeltaDto implements Serializable {

	@Schema(description = "Identifier of the accountUser", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "00df761c-1140-4ec1-8386-82e9af9e9f02")
	private String name;
	@Schema(description = "", example = "3b821d3a-aeb0-4704-a5b0-12548794f169")
	private String account;
	@Schema(description = "", example = "b2c37a6d-07a4-43b6-a7e4-11baeaa3711d")
	private String user;
	@Schema(description = "", example = "172ca8ef-1d1c-46e6-96f8-e4762db0ecef")
	private String username;
	@Schema(description = "", example = "51ae277c-48ea-4036-ab9c-ceaaf5d90ce8")
	private String details;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
