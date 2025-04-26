package com.groupe2cs.bizyhub.security.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResetPasswordDto  implements Serializable {

@Schema(description = "token ", example = "38058cb7-4dde-446e-908e-3c887052a4c1")
private String token;

@Schema(description = "newPassword", example = "admin")
private String newPassword;
}
