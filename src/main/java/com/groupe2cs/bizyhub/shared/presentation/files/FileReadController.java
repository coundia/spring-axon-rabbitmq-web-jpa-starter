package com.groupe2cs.bizyhub.shared.presentation.files;

import com.groupe2cs.bizyhub.fileManager.application.dto.FileManagerResponse;
import com.groupe2cs.bizyhub.fileManager.application.usecase.FileManagerReadApplicationService;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.FileManagerName;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileReadController {

	@Value("${app.file.upload-dir:uploads}")
	private String uploadDir;

	final private FileManagerReadApplicationService fileManagerReadApplicationService;

	@GetMapping("/{filename:.+}")
	public ResponseEntity<Resource> readFile(@PathVariable String filename, @AuthenticationPrincipal Jwt jwt) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt))
					.tenantId(RequestContext.getTenantId(jwt))
					.build();

			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			List<FileManagerResponse> fileManagerResponseList = fileManagerReadApplicationService
					.findByFileManagerName(FileManagerName.create(filename), metaRequest);

			if (fileManagerResponseList.isEmpty()) {
				log.error("File not found: {}", filename);
				return ResponseEntity.notFound().build();
			}

			Path filePath = Paths.get(uploadDir).toAbsolutePath().resolve(filename).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_DISPOSITION,
								"attachment; filename=\"" + resource.getFilename() + "\"")
						.body(resource);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (MalformedURLException e) {
			return ResponseEntity.notFound().build();
		}
	}


}
