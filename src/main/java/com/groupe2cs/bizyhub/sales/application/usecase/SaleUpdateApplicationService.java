package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.sales.application.command.UpdateSaleCommand;
import com.groupe2cs.bizyhub.sales.application.dto.SaleRequest;
import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.mapper.SaleMapper;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleId;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleUpdateApplicationService {

    private final FileStorageService fileStorageService;
    private final CommandGateway commandGateway;


    public SaleResponse updateSale(SaleId id, SaleRequest request) {

        UpdateSaleCommand command = SaleMapper.toUpdateCommand(
                id,
                request
        );

        commandGateway.sendAndWait(command);

        return SaleMapper.toResponse(command);
    }

}
