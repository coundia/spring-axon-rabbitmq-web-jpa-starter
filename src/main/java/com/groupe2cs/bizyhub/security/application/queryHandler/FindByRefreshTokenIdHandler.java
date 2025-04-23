package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.domain.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindByRefreshTokenIdHandler {

private final RefreshTokenRepository repository;
@QueryHandler

 public RefreshTokenResponse handle(FindByRefreshTokenIdQuery query) {
	String value = query.getId().value();
	RefreshToken entity = repository.findById(value)
		.orElseThrow(() -> new RefreshTokenNotFoundException("Id", value));
		return RefreshTokenMapper.toResponse(entity);
	}

}
