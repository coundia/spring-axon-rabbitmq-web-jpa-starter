package com.groupe2cs.bizyhub.fileManager.application.queryHandler;

import com.groupe2cs.bizyhub.fileManager.application.mapper.*;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;
import com.groupe2cs.bizyhub.fileManager.infrastructure.entity.*;
import com.groupe2cs.bizyhub.fileManager.application.dto.*;
import com.groupe2cs.bizyhub.fileManager.infrastructure.repository.*;
import com.groupe2cs.bizyhub.fileManager.application.query.*;
import com.groupe2cs.bizyhub.fileManager.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByFileManagerDetailsHandler {

private final FileManagerRepository repository;

@QueryHandler
public List<FileManagerResponse> handle(FindByFileManagerDetailsQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<FileManager> entities = null;
	 String value = query.getDetails().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByDetailsAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByDetailsAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(FileManagerMapper::toResponse)
	.toList();
	}


}
