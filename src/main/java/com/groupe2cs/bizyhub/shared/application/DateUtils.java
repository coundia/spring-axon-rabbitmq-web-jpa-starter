package com.groupe2cs.bizyhub.shared.application;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.ZoneOffset;

public class DateUtils {

	public static String convertToIsoFormat(String inputIsoDate) {
		Instant instant = Instant.parse(inputIsoDate);
		return instant.truncatedTo(java.time.temporal.ChronoUnit.SECONDS)
				.atZone(ZoneOffset.UTC)
				.format(DateTimeFormatter.ISO_INSTANT);
	}

	public static Instant convertToIsoInstant(String inputIsoDate) {
		return Instant.parse(inputIsoDate)
				.truncatedTo(java.time.temporal.ChronoUnit.SECONDS);
	}


}
