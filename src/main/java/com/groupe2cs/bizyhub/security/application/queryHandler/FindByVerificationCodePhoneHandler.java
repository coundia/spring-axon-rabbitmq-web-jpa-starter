package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByVerificationCodePhoneHandler {

private final VerificationCodeRepository repository;

@QueryHandler
public List<VerificationCodeResponse> handle(FindByVerificationCodePhoneQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<VerificationCode> entities = null;
	 String value = query.getPhone().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByPhoneAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByPhoneAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(VerificationCodeMapper::toResponse)
	.toList();
	}


}
