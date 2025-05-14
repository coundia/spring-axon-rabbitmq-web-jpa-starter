package com.groupe2cs.bizyhub.settings.application.query;

import com.groupe2cs.bizyhub.settings.domain.valueObject.SettingDetails;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindBySettingDetailsQuery {

	private final SettingDetails details;
	private final MetaRequest metaRequest;

}
