package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreateUserCommand;
import com.groupe2cs.bizyhub.security.application.dto.UserRequest;
import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreateApplicationService {
	private final CommandGateway commandGateway;

	public UserResponse createUser(UserRequest request) {

		CreateUserCommand command = UserMapper.toCommand(
				request
		);
		commandGateway.sendAndWait(command);
		return UserMapper.toResponse(command);
	}


}
