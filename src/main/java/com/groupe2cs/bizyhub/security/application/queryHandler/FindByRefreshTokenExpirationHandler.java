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
public class FindByRefreshTokenExpirationHandler {

private final RefreshTokenRepository repository;
@QueryHandler
public List<RefreshTokenResponse> handle(FindByRefreshTokenExpirationQuery query) {
java.time.Instant value = query.getExpiration().value();
	List<RefreshToken> entities = repository.findByExpiration(value);
	return entities.stream()
	.map(RefreshTokenMapper::toResponse)
	.toList();
	}


}
