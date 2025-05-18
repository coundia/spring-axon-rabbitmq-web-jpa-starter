package com.groupe2cs.bizyhub.shared.application;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

public class DateUtilsTest {

	@Test
	void it_should_preserve_original_date_and_convert_to_iso_format() {
		String input = "2025-05-17T20:32:23.907375Z";
		String expected = "2025-05-17T20:32:23Z";
		String result = DateUtils.convertToIsoFormat(input);
		assertThat(result).isEqualTo(expected);
	}

	@Test
	void it_should_preserve_another_date_and_convert_to_iso_format() {
		String input = "2023-12-01T08:00:00Z";
		String expected = "2023-12-01T08:00:00Z";
		String result = DateUtils.convertToIsoFormat(input);
		assertThat(result).isEqualTo(expected);
	}

	@Test
	void it_should_convert_to_iso_instant_truncated_to_seconds() {
		String input = "2025-05-17T20:32:23.907375Z";
		Instant expected = Instant.parse("2025-05-17T20:32:23Z");
		Instant result = DateUtils.convertToIsoInstant(input);
		assertThat(result).isEqualTo(expected);
	}
}
