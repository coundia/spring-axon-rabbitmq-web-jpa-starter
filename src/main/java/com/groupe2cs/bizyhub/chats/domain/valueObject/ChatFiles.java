package com.groupe2cs.bizyhub.chats.domain.valueObject;

import com.groupe2cs.bizyhub.chats.domain.exception.ChatFilesNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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
