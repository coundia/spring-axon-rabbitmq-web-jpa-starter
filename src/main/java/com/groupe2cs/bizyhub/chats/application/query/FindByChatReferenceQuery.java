package com.groupe2cs.bizyhub.chats.application.query;

import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatReference;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByChatReferenceQuery {

	private final ChatReference reference;
	private final MetaRequest metaRequest;

}
