package com.groupe2cs.bizyhub.order.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.order.application.query.*;
import com.groupe2cs.bizyhub.order.application.command.*;
import com.groupe2cs.bizyhub.order.domain.valueObject.*;
import com.groupe2cs.bizyhub.order.application.dto.*;
import com.groupe2cs.bizyhub.order.application.mapper.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteOrder(OrderId idVo, MetaRequest metaRequest) {

DeleteOrderCommand command = new DeleteOrderCommand(idVo);
commandGateway.sendAndWait(command);
}
}
