package com.groupe2cs.bizyhub.chats.domain.exception;

import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatId;

public class ChatNotFoundException extends RuntimeException {

public ChatNotFoundException(String object, String value) {
super("Chat with "+object+": '" + value + "' not found");
}
}
