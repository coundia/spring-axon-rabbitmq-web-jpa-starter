package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.sales.application.command.CreateSaleCommand;
import com.groupe2cs.bizyhub.sales.application.dto.SaleRequest;
import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.mapper.SaleMapper;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleFacture;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class SaleCreateApplicationService {
    private final FileStorageService fileStorageService;
    private final CommandGateway commandGateway;

    public SaleResponse createSale(MultipartFile facture, Integer quantity, Double totalPrice) {
        SaleFacture factureReference = SaleFacture.create(fileStorageService.storeFile(facture));

        SaleRequest request = new SaleRequest(quantity, totalPrice);

        CreateSaleCommand command = SaleMapper.toCommand(request, factureReference);

        commandGateway.sendAndWait(command);

        return SaleMapper.toResponse(command);
    }
}
