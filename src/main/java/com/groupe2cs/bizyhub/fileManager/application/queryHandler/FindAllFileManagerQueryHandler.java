package com.groupe2cs.bizyhub.fileManager.application.queryHandler;

import com.groupe2cs.bizyhub.fileManager.application.dto.FileManagerPagedResponse;
import com.groupe2cs.bizyhub.fileManager.application.dto.FileManagerResponse;
import com.groupe2cs.bizyhub.fileManager.application.mapper.FileManagerMapper;
import com.groupe2cs.bizyhub.fileManager.application.query.FindAllFileManagerQuery;
import com.groupe2cs.bizyhub.fileManager.infrastructure.entity.FileManager;
import com.groupe2cs.bizyhub.fileManager.infrastructure.repository.FileManagerRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


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

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all FileManagers");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {
			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);
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
