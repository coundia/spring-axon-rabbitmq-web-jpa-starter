package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreateUserCommand;
import com.groupe2cs.bizyhub.security.application.dto.UserRequest;
import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreateApplicationService {
	private final CommandGateway commandGateway;

	public UserResponse createUser(UserRequest request,
								   MetaRequest metaRequest
	) {

		CreateUserCommand command = UserMapper.toCommand(
				request
		);

		command.setCreatedBy(UserCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(UserTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return UserMapper.toResponse(command);
	}


}
