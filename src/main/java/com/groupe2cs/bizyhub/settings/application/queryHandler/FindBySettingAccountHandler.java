package com.groupe2cs.bizyhub.settings.application.queryHandler;

import com.groupe2cs.bizyhub.settings.application.dto.SettingResponse;
import com.groupe2cs.bizyhub.settings.application.mapper.SettingMapper;
import com.groupe2cs.bizyhub.settings.application.query.FindBySettingAccountQuery;
import com.groupe2cs.bizyhub.settings.infrastructure.entity.Setting;
import com.groupe2cs.bizyhub.settings.infrastructure.repository.SettingRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindBySettingAccountHandler {

	private final SettingRepository repository;

	@QueryHandler
	public List<SettingResponse> handle(FindBySettingAccountQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Setting> entities = null;
		String value = query.getAccount().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByAccountAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByAccountAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(SettingMapper::toResponse)
				.toList();
	}


}
