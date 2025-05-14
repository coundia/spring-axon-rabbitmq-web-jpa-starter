package com.groupe2cs.bizyhub.settings.application.queryHandler;

import com.groupe2cs.bizyhub.settings.application.dto.SettingResponse;
import com.groupe2cs.bizyhub.settings.application.mapper.SettingMapper;
import com.groupe2cs.bizyhub.settings.application.query.FindBySettingDetailsQuery;
import com.groupe2cs.bizyhub.settings.infrastructure.entity.Setting;
import com.groupe2cs.bizyhub.settings.infrastructure.repository.SettingRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindBySettingDetailsHandler {

	private final SettingRepository repository;

	@QueryHandler
	public List<SettingResponse> handle(FindBySettingDetailsQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Setting> entities = null;
		String value = query.getDetails().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByDetailsAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByDetailsAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(SettingMapper::toResponse)
				.toList();
	}


}
