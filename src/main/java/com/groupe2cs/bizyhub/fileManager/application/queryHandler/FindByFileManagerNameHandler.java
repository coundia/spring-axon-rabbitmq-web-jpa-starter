package com.groupe2cs.bizyhub.fileManager.application.queryHandler;

import com.groupe2cs.bizyhub.fileManager.application.dto.FileManagerResponse;
import com.groupe2cs.bizyhub.fileManager.application.mapper.FileManagerMapper;
import com.groupe2cs.bizyhub.fileManager.application.query.FindByFileManagerNameQuery;
import com.groupe2cs.bizyhub.fileManager.infrastructure.entity.FileManager;
import com.groupe2cs.bizyhub.fileManager.infrastructure.repository.FileManagerRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByFileManagerNameHandler {

	private final FileManagerRepository repository;

	@QueryHandler
	public List<FileManagerResponse> handle(FindByFileManagerNameQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<FileManager> entities = null;
		String value = query.getName().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByNameAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByNameAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(FileManagerMapper::toResponse)
				.toList();
	}


}
