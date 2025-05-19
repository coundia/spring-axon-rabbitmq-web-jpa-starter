package com.groupe2cs.bizyhub.security.application.dto;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
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
@Schema(name = "UserResponse", description = "Response payload for User")
public class UserResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String username;
	@Schema(description = "", example = "")
	private String password;
	@Schema(description = "", example = "")
	private String firstName;
	@Schema(description = "", example = "")
	private String lastName;
	@Schema(description = "", example = "")
	private String email;
	@Schema(description = "", example = "")
	private String telephone;
	@Schema(description = "", example = "")
	private Integer limitPerDay;
	@Schema(description = "", example = "")
	private Boolean isPremium;
	@Schema(description = "", example = "")
	private Boolean enabled;
	@Schema(description = "", example = "")
	private Boolean isBan;
	@Schema(description = "", example = "")
	private String message;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
