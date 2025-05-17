package com.groupe2cs.bizyhub.categories.application.query;

import com.groupe2cs.bizyhub.categories.domain.valueObject.CategoryUpdatedAt;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByCategoryUpdatedAtQuery {

	private final CategoryUpdatedAt updatedAt;
	private final MetaRequest metaRequest;

}
