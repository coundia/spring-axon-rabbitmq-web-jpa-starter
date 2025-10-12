package com.groupe2cs.bizyhub.companies.application.dto;

import java.util.List;
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

@Schema(name = "CompanySyncRequest", description = "Request payload for synchronizing companys")
public class CompanySyncRequest implements Serializable {

	@Schema(description = "Batch of company deltas")
	private List<CompanyDeltaDto> deltas;
}

