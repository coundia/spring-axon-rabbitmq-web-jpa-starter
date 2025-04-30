package com.groupe2cs.bizyhub.settings.application.queryHandler;

import com.groupe2cs.bizyhub.settings.application.dto.SettingResponse;
import com.groupe2cs.bizyhub.settings.application.mapper.SettingMapper;
import com.groupe2cs.bizyhub.settings.application.query.FindBySettingNameQuery;
import com.groupe2cs.bizyhub.settings.infrastructure.entity.Setting;
import com.groupe2cs.bizyhub.settings.infrastructure.repository.SettingRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindBySettingNameHandler {

	private final SettingRepository repository;

	@QueryHandler

	public SettingResponse handle(FindBySettingNameQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();

		String value = query.getName().value();
		Setting entity = repository.findByNameAndCreatedById(value, metaRequest.getUserId())
				.orElse(null);

		if (entity == null) {
			return null;
		}

		return SettingMapper.toResponse(entity);
	}

}
