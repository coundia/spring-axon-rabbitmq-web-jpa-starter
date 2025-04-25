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

	@Schema(description = "", example = "fa904fc1-4bf6-4283-9972-ba4a949d3ed9")
	private String name;


}
