package com.groupe2cs.bizyhub.fileManager.application.query;

import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByFileManagerOriginalNameQuery {

	private final FileManagerOriginalName originalName;
	private final MetaRequest metaRequest;

}
