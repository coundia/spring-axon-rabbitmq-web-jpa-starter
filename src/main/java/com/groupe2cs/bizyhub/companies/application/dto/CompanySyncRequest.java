package com.groupe2cs.bizyhub.companies.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Schema(name = "CompanySyncRequest", description = "Request payload for synchronizing companys")
public class CompanySyncRequest implements Serializable {

	@Schema(description = "Batch of company deltas")
	private List<CompanyDeltaDto> deltas;
}

