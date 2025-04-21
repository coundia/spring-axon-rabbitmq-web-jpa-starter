package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.UpdateUserCommand;
import com.groupe2cs.bizyhub.security.application.dto.UserRequest;
import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserId;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public UserResponse updateUser(UserId id, UserRequest request) {

		UpdateUserCommand command = UserMapper.toUpdateCommand(
				id,
				request
		);

		commandGateway.sendAndWait(command);

		return UserMapper.toResponse(command);
	}

}
