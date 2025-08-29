package com.groupe2cs.bizyhub.fileManager.application.query;

import com.groupe2cs.bizyhub.fileManager.domain.valueObject.FileManagerPath;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByFileManagerPathQuery {

	private final FileManagerPath path;
	private final MetaRequest metaRequest;

}
