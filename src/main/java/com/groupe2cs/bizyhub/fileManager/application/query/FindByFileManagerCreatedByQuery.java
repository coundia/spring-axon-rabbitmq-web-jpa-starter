package com.groupe2cs.bizyhub.fileManager.application.query;

import com.groupe2cs.bizyhub.fileManager.domain.valueObject.FileManagerCreatedBy;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByFileManagerCreatedByQuery {

	private final FileManagerCreatedBy createdBy;
	private final MetaRequest metaRequest;

}
