package com.groupe2cs.bizyhub.sales.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class SaleMultipart {
    @Schema(description = "SaleRequest JSON")
    public SaleRequest metadata;

    @Schema(description = "Fichier PDF", type="string", format="binary")
    public org.springframework.core.io.Resource facture;
}
