package com.groupe2cs.bizyhub.settings.application.query;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindAllSettingQuery {

	private final int page;
	private final int limit;
	private final MetaRequest metaRequest;

}
