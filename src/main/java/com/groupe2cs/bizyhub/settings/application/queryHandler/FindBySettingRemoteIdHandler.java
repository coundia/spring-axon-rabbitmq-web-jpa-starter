package com.groupe2cs.bizyhub.settings.application.queryHandler;

import com.groupe2cs.bizyhub.settings.application.dto.SettingResponse;
import com.groupe2cs.bizyhub.settings.application.mapper.SettingMapper;
import com.groupe2cs.bizyhub.settings.application.query.FindBySettingRemoteIdQuery;
import com.groupe2cs.bizyhub.settings.infrastructure.entity.Setting;
import com.groupe2cs.bizyhub.settings.infrastructure.repository.SettingRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindBySettingRemoteIdHandler {

	private final SettingRepository repository;

	@QueryHandler
	public List<SettingResponse> handle(FindBySettingRemoteIdQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Setting> entities = null;
		String value = query.getRemoteId().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByRemoteIdAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByRemoteIdAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(SettingMapper::toResponse)
				.toList();
	}


}
