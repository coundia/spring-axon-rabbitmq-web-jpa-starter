package com.groupe2cs.bizyhub.products.application.dto;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;

@Value
@Builder
public class ProductImageResponse {
	String id;
	String filename;
	String contentType;
	Long size;
	String url;
	Instant createdAt;
}
