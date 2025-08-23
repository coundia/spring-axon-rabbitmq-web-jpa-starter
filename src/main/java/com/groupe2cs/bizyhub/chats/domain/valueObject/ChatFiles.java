package com.groupe2cs.bizyhub.chats.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatIdNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatMessagesNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatResponsesJsonNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatResponsesNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatStateNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatSyncAtNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatAccountNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatFilesNotValid;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ChatFiles implements Serializable {

private String files;

public ChatFiles(String files) {
this.files = files;
}

public static ChatFiles create(String files) {

if (files == null || files.isBlank()) {
throw new ChatFilesNotValid("Files is invalid");
}
return new ChatFiles(files);
}

public String value() {
return this.files;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChatFiles that)) return false;
return this.files.equals(that.files);
}

@Override
public int hashCode() {
return java.util.Objects.hash(files);
}

@Override
public String toString() {
return String.valueOf(files);
}
}
