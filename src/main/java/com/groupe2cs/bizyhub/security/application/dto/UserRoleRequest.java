package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "UserRoleRequest", description = "Request payload for UserRole operations")
public class UserRoleRequest implements Serializable {

	@Schema(description = "", example = "13f77eaf-2fc0-46d1-9daf-01592d91600b")
	private String user;
	@Schema(description = "", example = "9ecaeac5-2465-4f45-acea-893b4de15dfc")
	private String role;

}
