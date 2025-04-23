package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public UserResponse updateUser(UserId id,UserRequest request){

UpdateUserCommand command = UserMapper.toUpdateCommand(
id,
request
);

commandGateway.sendAndWait(command);

return UserMapper.toResponse(command);
}

}
