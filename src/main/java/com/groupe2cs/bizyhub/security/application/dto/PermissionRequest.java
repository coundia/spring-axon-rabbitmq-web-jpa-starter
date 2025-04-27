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

	@Schema(description = "", example = "eaef8c4b-fa5d-4e24-b752-fd9e8d3c1ac3")
	private String name;


}
