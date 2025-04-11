package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.application.mapper.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;

public String createSale(
	MultipartFile facture
,
		Integer quantity,
		Double totalPrice
) {
	SaleFacture factureReference = SaleFacture.create(fileStorageService.storeFile(facture));

SaleRequest request = new SaleRequest(
	
	quantity,
	totalPrice
);

CreateSaleCommand command = SaleMapper.toCommand(
request,
factureReference
);

return commandGateway.sendAndWait(command).toString();
}
}
