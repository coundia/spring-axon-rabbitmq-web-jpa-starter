package com.groupe2cs.bizyhub.shared.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {

@Value("${app.file.upload-dir:uploads}")
private String uploadDir;

@Override
public String storeFile(MultipartFile file) {
	try {
	Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
	Files.createDirectories(uploadPath);

	String originalFilename = file.getOriginalFilename();
	String safeFilename = (originalFilename != null) ? originalFilename.replaceAll("\\s+", "_") : "file";
	String filename = UUID.randomUUID() + "_" + safeFilename;

	Path filePath = uploadPath.resolve(filename);
	file.transferTo(filePath.toFile());

return filePath.toString();
} catch (IOException ex) {
	throw new RuntimeException("Failed to store file: " + ex.getMessage(), ex);
}
}
}
