package com.groupe2cs.bizyhub.settings.domain.valueObject;

import com.groupe2cs.bizyhub.settings.domain.exception.SettingLocaleNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SettingLocale implements Serializable {

	private String locale;

	public SettingLocale(String locale) {
		this.locale = locale;
	}

	public static SettingLocale create(String locale) {

		if (locale == null || locale.isBlank()) {
			throw new SettingLocaleNotValid("Locale is invalid");
		}
		return new SettingLocale(locale);
	}

	public String value() {
		return this.locale;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SettingLocale that)) return false;
		return this.locale.equals(that.locale);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(locale);
	}

	@Override
	public String toString() {
		return String.valueOf(locale);
	}
}
