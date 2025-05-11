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

	@Schema(description = "", example = "4d7257f5-ff4e-4f9a-a34f-6ff6d6bc2ba5")
	private String username;

	@Schema(description = "", example = "5caeac01-b617-4c3c-9f99-5b90186bb40f")
	private String password;


}
