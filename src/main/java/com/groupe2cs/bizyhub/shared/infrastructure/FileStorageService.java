package com.groupe2cs.bizyhub.shared.infrastructure;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileStorageService {

	String storeFile(List<MultipartFile> file, MetaRequest metaRequest);
}
