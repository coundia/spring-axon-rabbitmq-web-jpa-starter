package com.groupe2cs.bizyhub.customers.application.dto;

import com.groupe2cs.bizyhub.customers.domain.valueObject.*;
import com.groupe2cs.bizyhub.customers.infrastructure.entity.*;
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
@Schema(name = "CustomerResponse", description = "Response payload for Customer")
public class CustomerResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String remoteId;
	@Schema(description = "", example = "")
	private String code;
	@Schema(description = "", example = "")
	private String firstName;
	@Schema(description = "", example = "")
	private String lastName;
	@Schema(description = "", example = "")
	private String fullName;
	@Schema(description = "", example = "")
	private Double balance;
	@Schema(description = "", example = "")
	private Double balanceDebt;
	@Schema(description = "", example = "")
	private String phone;
	@Schema(description = "", example = "")
	private String email;
	@Schema(description = "", example = "")
	private String notes;
	@Schema(description = "", example = "")
	private String status;
	@Schema(description = "", example = "")
	private String company;
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
	private String postalCode;
	@Schema(description = "", example = "")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "")
	private Boolean isActive;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
