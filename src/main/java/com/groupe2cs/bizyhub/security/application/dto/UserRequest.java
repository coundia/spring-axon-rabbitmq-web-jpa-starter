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

	@Schema(description = "", example = "69efd62b-3b62-48a8-bbc4-95af4dde68cd")
	private String username;
	@Schema(description = "", example = "c9243279-bb3e-4f88-8797-8faf6ca82d6d")
	private String password;
	@Schema(description = "", example = "b34b7877-1d95-41f8-b8f2-fbd54e3aeaa2")
	private String firstName;
	@Schema(description = "", example = "0a72f29c-bed6-45a5-93a1-3c0b9883a0e1")
	private String lastName;
	@Schema(description = "", example = "4d1a27e0-ea7c-41f7-8f33-c1160723dea2")
	private String email;
	@Schema(description = "", example = "688d7bd8-5993-4dc9-a618-5f96a1cba251")
	private String telephone;
	@Schema(description = "", example = "44")
	private Integer limitPerDay;
	@Schema(description = "", example = "true")
	private Boolean isPremium;
	@Schema(description = "", example = "true")
	private Boolean enabled;
	@Schema(description = "", example = "true")
	private Boolean isBan;
	@Schema(description = "", example = "89ddc196-899e-4bb6-8a26-0deaae0721e8")
	private String message;

}
