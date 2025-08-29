package com.groupe2cs.bizyhub.settings.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SettingLocalId implements Serializable {

	private String localId;

	public SettingLocalId(String localId) {
		this.localId = localId;
	}

	public static SettingLocalId create(String localId) {

		return new SettingLocalId(localId);
	}

	public String value() {
		return this.localId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SettingLocalId that)) return false;
		return this.localId.equals(that.localId);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(localId);
	}

	@Override
	public String toString() {
		return String.valueOf(localId);
	}
}
