package com.groupe2cs.bizyhub.categories.application.query;

import com.groupe2cs.bizyhub.categories.domain.valueObject.CategoryDescription;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByCategoryDescriptionQuery {

	private final CategoryDescription description;
	private final MetaRequest metaRequest;

}
