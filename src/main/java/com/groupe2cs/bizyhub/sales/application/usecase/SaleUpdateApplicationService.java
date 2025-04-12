package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.application.command.*;
import com.groupe2cs.bizyhub.sales.application.query.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;

public SaleResponse updateSale(
SaleId id,
MultipartFile facture,
		Integer quantity,
		Double totalPrice
) {
	SaleFacture factureReference = SaleFacture.create(fileStorageService.storeFile(facture));

SaleRequest request = new SaleRequest(
	
	quantity,
	totalPrice
);

UpdateSaleCommand command = SaleMapper.toUpdateCommand(
id,
request,
factureReference
);

commandGateway.sendAndWait(command);

return SaleMapper.toResponse(command);
}
}
