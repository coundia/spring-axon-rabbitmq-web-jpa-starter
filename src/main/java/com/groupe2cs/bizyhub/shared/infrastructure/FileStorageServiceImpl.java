package com.groupe2cs.bizyhub.shared.infrastructure;

import com.groupe2cs.bizyhub.fileManager.application.dto.FileManagerRequest;
import com.groupe2cs.bizyhub.fileManager.application.usecase.FileManagerCreateApplicationService;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {

	private final FileManagerCreateApplicationService fileManagerCreateApplicationService;
	@Value("${app.file.upload-dir:uploads}")
	private String uploadDir;
	@Value("${app.file.uri:http://localhost:8080/api/v1/files}")
	private String baseFileUri;

	@Override
	public String storeFile(List<MultipartFile> files, MetaRequest metaRequest) {
		if (files == null || files.isEmpty()) {
			return Utils.toJson(List.of());
		}
		List<String> uris = files.stream()
				.map(file -> processFile(file, metaRequest))
				.collect(Collectors.toList());
		return Utils.toJson(uris);
	}

	private String processFile(MultipartFile file, MetaRequest metaRequest) {
		String storedPath = saveToDiskWithUuidName(file);

		String fileNameOnDisk = Paths.get(storedPath).getFileName().toString();
		String originalName = file.getOriginalFilename();
		String uri = baseFileUri + "/" + fileNameOnDisk;

		FileManagerRequest request = FileManagerRequest.builder()
				.uri(uri)
				.name(fileNameOnDisk)
				.size(file.getSize())
				.mimeType(file.getContentType())
				.objectId(metaRequest.getObjectId())
				.objectName(metaRequest.getObjectName())
				.originalName(originalName)
				.path(storedPath)
				.isPublic(metaRequest.getIsPublic())
				.build();

		fileManagerCreateApplicationService.createFileManager(request, metaRequest);
		return uri;
	}

	private String saveToDiskWithUuidName(MultipartFile file) {
		try {
			Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
			Files.createDirectories(uploadPath);
			String original = file.getOriginalFilename();
			String ext = "";

			if (original != null && original.contains(".")) {
				ext = original.substring(original.lastIndexOf('.'));
			}

			String fileName = UUID.randomUUID() + ext;
			Path target = uploadPath.resolve(fileName);
			file.transferTo(target.toFile());
			return target.toString();
		} catch (IOException e) {
			throw new RuntimeException("Failed to store file " + file.getOriginalFilename(), e);
		}
	}
}
