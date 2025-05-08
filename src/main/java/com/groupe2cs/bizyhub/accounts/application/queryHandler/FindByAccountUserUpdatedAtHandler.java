package com.groupe2cs.bizyhub.accounts.application.queryHandler;

import com.groupe2cs.bizyhub.accounts.application.mapper.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.accounts.application.query.*;
import com.groupe2cs.bizyhub.accounts.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindByAccountUserUpdatedAtHandler {

private final AccountUserRepository repository;
@QueryHandler
public List<AccountUserResponse> handle(FindByAccountUserUpdatedAtQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();

java.time.Instant value = query.getUpdatedAt().value();
	List<AccountUser> entities = repository.findByUpdatedAtAndCreatedById(value, metaRequest.getUserId());
	return entities.stream()
	.map(AccountUserMapper::toResponse)
	.toList();
	}


}
