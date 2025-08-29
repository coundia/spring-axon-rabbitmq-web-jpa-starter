package com.groupe2cs.bizyhub.settings.domain.valueObject;

import com.groupe2cs.bizyhub.settings.domain.exception.SettingValueNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SettingValue implements Serializable {

	private String value;

	public SettingValue(String value) {
		this.value = value;
	}

	public static SettingValue create(String value) {

		if (value == null || value.isBlank()) {
			throw new SettingValueNotValid("Value is invalid");
		}
		return new SettingValue(value);
	}

	public String value() {
		return this.value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SettingValue that)) return false;
		return this.value.equals(that.value);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
