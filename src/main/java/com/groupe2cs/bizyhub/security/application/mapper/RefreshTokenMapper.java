package com.groupe2cs.bizyhub.security.application.mapper;

import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.domain.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.application.command.*;


public class RefreshTokenMapper {

public static RefreshTokenResponse toResponse(RefreshToken entity) {
return new RefreshTokenResponse(
		entity.getId(), 
		entity.getToken(), 
		entity.getUsername(), 
		entity.getExpiration()
);
}

public static RefreshTokenResponse toResponse(CreateRefreshTokenCommand command) {
return new RefreshTokenResponse(
command.getId().value(), command.getToken().value(), command.getUsername().value(), command.getExpiration().value()
);
}

public static RefreshTokenResponse toResponse(UpdateRefreshTokenCommand command) {
return new RefreshTokenResponse(
command.getId().value(), command.getToken().value(), command.getUsername().value(), command.getExpiration().value()
);
}


public static CreateRefreshTokenCommand toCommand(
RefreshTokenRequest request
) {
return new CreateRefreshTokenCommand(
RefreshTokenToken.create(request.getToken()), RefreshTokenUsername.create(request.getUsername()), RefreshTokenExpiration.create(request.getExpiration())
);
}
public static UpdateRefreshTokenCommand toUpdateCommand(RefreshTokenId id, RefreshTokenRequest request) {
return new UpdateRefreshTokenCommand(
id, RefreshTokenToken.create(request.getToken()), RefreshTokenUsername.create(request.getUsername()), RefreshTokenExpiration.create(request.getExpiration())
);
}


public static DeleteRefreshTokenCommand toDeleteCommand(RefreshTokenId id) {
return new DeleteRefreshTokenCommand(id);
}
}
