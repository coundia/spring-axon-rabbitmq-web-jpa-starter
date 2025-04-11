package com.groupe2cs.bizyhub.shared.infrastructure;

import org.springframework.stereotype.Service;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageServiceImpl implements FileStorageService {

private static final String UPLOAD_DIR = "uploads";

@Override
public String storeFile(MultipartFile file) {
try {
Path uploadPath = Paths.get(UPLOAD_DIR);
if (!Files.exists(uploadPath)) {
Files.createDirectories(uploadPath);
}

String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
Path filePath = uploadPath.resolve(filename);
file.transferTo(filePath.toFile());

return filePath.toString();
} catch (IOException ex) {
throw new RuntimeException("Failed to store file: " + ex.getMessage(), ex);
}
}
}
