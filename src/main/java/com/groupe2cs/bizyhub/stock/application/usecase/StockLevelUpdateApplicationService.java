package com.groupe2cs.bizyhub.stock.application.usecase;

import com.groupe2cs.bizyhub.stock.application.command.*;
import com.groupe2cs.bizyhub.stock.application.query.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.application.mapper.*;
import com.groupe2cs.bizyhub.stock.application.dto.*;
import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockLevelUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public StockLevelResponse updateStockLevel(StockLevelId id,StockLevelRequest request,
MetaRequest metaRequest
){

UpdateStockLevelCommand command = StockLevelMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(StockLevelCreatedBy.create(metaRequest.getUserId()));
command.setTenant(StockLevelTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return StockLevelMapper.toResponse(command);
}

}
