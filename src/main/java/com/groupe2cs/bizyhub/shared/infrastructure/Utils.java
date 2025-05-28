package com.groupe2cs.bizyhub.shared.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Utils {
	public static String toJson(List<String> list) {
		try {
			return new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Failed to convert list to JSON", e);
		}
	}
}
