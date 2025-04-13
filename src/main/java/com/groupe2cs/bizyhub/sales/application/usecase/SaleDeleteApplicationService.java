package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.sales.application.command.DeleteSaleCommand;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleDeleteApplicationService {

    private final CommandGateway commandGateway;

    public void deleteSale(SaleId idVo) {

        DeleteSaleCommand command = new DeleteSaleCommand(idVo);
        commandGateway.sendAndWait(command);
    }
}
