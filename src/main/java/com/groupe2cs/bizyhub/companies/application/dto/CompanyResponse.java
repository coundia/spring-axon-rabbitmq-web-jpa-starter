package com.groupe2cs.bizyhub.companies.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "CompanyResponse", description = "Response payload for Company")
public class CompanyResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String remoteId;
	@Schema(description = "", example = "")
	private String localId;
	@Schema(description = "", example = "")
	private String code;
	@Schema(description = "", example = "")
	private String name;
	@Schema(description = "", example = "")
	private String description;
	@Schema(description = "", example = "")
	private String phone;
	@Schema(description = "", example = "")
	private String email;
	@Schema(description = "", example = "")
	private String website;
	@Schema(description = "", example = "")
	private String taxId;
	@Schema(description = "", example = "")
	private String currency;
	@Schema(description = "", example = "")
	private String addressLine1;
	@Schema(description = "", example = "")
	private String addressLine2;
	@Schema(description = "", example = "")
	private String city;
	@Schema(description = "", example = "")
	private String region;
	@Schema(description = "", example = "")
	private String country;
	@Schema(description = "", example = "")
	private String account;
	@Schema(description = "", example = "")
	private String postalCode;
	@Schema(description = "", example = "")
	private Boolean isActive;
	@Schema(description = "", example = "")
	private String status;
	@Schema(description = "", example = "")
	private Boolean isPublic;
	@Schema(description = "", example = "")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "")
	private Boolean isDefault;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
