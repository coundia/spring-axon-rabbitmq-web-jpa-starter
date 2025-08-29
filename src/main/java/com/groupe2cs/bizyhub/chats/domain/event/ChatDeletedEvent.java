package com.groupe2cs.bizyhub.chats.domain.event;

import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatDeletedEvent implements Serializable {


	private ChatId id;

}
