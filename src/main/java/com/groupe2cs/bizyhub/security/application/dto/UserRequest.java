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

	@Schema(description = "", example = "ed8baea3-e5b6-4a02-94cf-729ffcc1eea2")
	private String username;
	@Schema(description = "", example = "a43c75e1-ed93-440c-90c9-41b97625ed0d")
	private String password;
	@Schema(description = "", example = "17d897d5-950a-406c-8438-ba8da382f25c")
	private String firstName;
	@Schema(description = "", example = "4edb5778-5afd-4ebc-bcf6-faff1724a1f0")
	private String lastName;
	@Schema(description = "", example = "a18f4721-0ddf-4959-9189-616fb0a5265d")
	private String email;
	@Schema(description = "", example = "8842a8b2-fd5a-41bf-b3cc-c514c007e3d4")
	private String telephone;
	@Schema(description = "", example = "47")
	private Integer limitPerDay;
	@Schema(description = "", example = "true")
	private Boolean isPremium;
	@Schema(description = "", example = "true")
	private Boolean enabled;
	@Schema(description = "", example = "false")
	private Boolean isBan;
	@Schema(description = "", example = "dcb979a1-a5c1-4af2-863a-ee8d62836c59")
	private String message;

}
