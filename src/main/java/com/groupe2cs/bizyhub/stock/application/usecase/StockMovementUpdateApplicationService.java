package com.groupe2cs.bizyhub.stock.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.application.mapper.*;
import com.groupe2cs.bizyhub.stock.application.dto.*;
import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import com.groupe2cs.bizyhub.stock.application.command.*;
import com.groupe2cs.bizyhub.stock.application.query.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockMovementUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public StockMovementResponse updateStockMovement(StockMovementId id,StockMovementRequest request,
MetaRequest metaRequest
){

UpdateStockMovementCommand command = StockMovementMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(StockMovementCreatedBy.create(metaRequest.getUserId()));
command.setTenant(StockMovementTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return StockMovementMapper.toResponse(command);
}

}
