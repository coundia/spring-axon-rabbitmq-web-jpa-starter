package com.groupe2cs.bizyhub.fileManager.application.query;

import com.groupe2cs.bizyhub.fileManager.domain.valueObject.FileManagerMimeType;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByFileManagerMimeTypeQuery {

	private final FileManagerMimeType mimeType;
	private final MetaRequest metaRequest;

}
