package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "PermissionRequest", description = "Request payload for Permission operations")
public class PermissionRequest implements Serializable {

	@Schema(description = "", example = "aba694a7-2073-4d8b-8cb2-fa7fbba10388")
	private String name;

}
