package com.groupe2cs.bizyhub.fileManager.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.fileManager.application.dto.*;
import com.groupe2cs.bizyhub.fileManager.infrastructure.repository.*;
import com.groupe2cs.bizyhub.fileManager.application.query.*;
import com.groupe2cs.bizyhub.fileManager.infrastructure.entity.*;
import com.groupe2cs.bizyhub.fileManager.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FindAllFileManagerQueryHandler {

private final FileManagerRepository repository;

public FindAllFileManagerQueryHandler(FileManagerRepository repository) {
	this.repository = repository;
}

@QueryHandler
public FileManagerPagedResponse handle(FindAllFileManagerQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<FileManager> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all FileManagers");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{

log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);


}

List<FileManagerResponse> responses = pages.stream()
	.map(FileManagerMapper::toResponse)
	.toList();

	return FileManagerPagedResponse.from(
	pages,
	responses
	);
	}
}
