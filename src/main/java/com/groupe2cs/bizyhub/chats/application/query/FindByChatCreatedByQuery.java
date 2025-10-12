package com.groupe2cs.bizyhub.chats.application.query;

import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatCreatedBy;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByChatCreatedByQuery {

	private final ChatCreatedBy createdBy;
	private final MetaRequest metaRequest;

}
