package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.sales.application.command.CreateSaleCommand;
import com.groupe2cs.bizyhub.sales.application.dto.SaleRequest;
import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.mapper.SaleMapper;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleCreateApplicationService {
    private final CommandGateway commandGateway;

    public SaleResponse createSale(SaleRequest request) {

        CreateSaleCommand command = SaleMapper.toCommand(
                request
        );
        commandGateway.sendAndWait(command);
        return SaleMapper.toResponse(command);
    }


}
