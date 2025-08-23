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

	@Schema(description = "", example = "dddbf9fe-37bc-424a-aaf9-682ebfddfd3a")
	private String username;
	@Schema(description = "", example = "dfcf4a7c-e321-434c-b968-ac16baf716bd")
	private String password;
	@Schema(description = "", example = "6e9f50cf-484b-45b2-9969-def067c4ba82")
	private String firstName;
	@Schema(description = "", example = "b6a06740-9a6f-46f1-b732-28326d71722b")
	private String lastName;
	@Schema(description = "", example = "399fdf18-a4ec-47d9-9018-8a0c1bd7c9af")
	private String email;
	@Schema(description = "", example = "df529c3e-181e-4fe7-a152-6c1149f00b41")
	private String telephone;
	@Schema(description = "", example = "20")
	private Integer limitPerDay;
	@Schema(description = "", example = "true")
	private Boolean isPremium;
	@Schema(description = "", example = "true")
	private Boolean enabled;
	@Schema(description = "", example = "true")
	private Boolean isBan;
	@Schema(description = "", example = "775ec915-a966-4893-a7d7-3d26db6cb5b4")
	private String message;

}
