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

	@Schema(description = "", example = "1394573d-8e1a-4364-b56d-fe8725af6929")
	private String username;
	@Schema(description = "", example = "d3a49890-12e3-4e26-9380-be0642a5a09f")
	private String password;
	@Schema(description = "", example = "34c343bf-b3bd-43bc-8389-9872e7ca5722")
	private String firstName;
	@Schema(description = "", example = "5af0f397-4f6d-423e-b78c-53cf128a1c2d")
	private String lastName;
	@Schema(description = "", example = "f28dafad-d107-408c-9771-3f9d8f2e2154")
	private String email;
	@Schema(description = "", example = "5db71b1b-61f8-451e-be9f-470cdba86249")
	private String telephone;
	@Schema(description = "", example = "96")
	private Integer limitPerDay;
	@Schema(description = "", example = "false")
	private Boolean isPremium;
	@Schema(description = "", example = "false")
	private Boolean enabled;
	@Schema(description = "", example = "false")
	private Boolean isBan;
	@Schema(description = "", example = "a6094350-ddc6-4467-b1ee-430fdffe8fcc")
	private String message;

}
