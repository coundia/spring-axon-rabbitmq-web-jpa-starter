package com.groupe2cs.bizyhub.settings.application.query;

import com.groupe2cs.bizyhub.settings.domain.valueObject.SettingUpdatedAt;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindBySettingUpdatedAtQuery {

	private final SettingUpdatedAt updatedAt;
	private final MetaRequest metaRequest;

}
