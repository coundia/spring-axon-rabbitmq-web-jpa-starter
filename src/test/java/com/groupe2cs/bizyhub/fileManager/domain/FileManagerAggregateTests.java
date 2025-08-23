package com.groupe2cs.bizyhub.fileManager.domain;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.fileManager.domain.exception.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FileManagerAggregateTests extends BaseUnitTests {

@Test
void it_should_create_fileManager_with_valid_values() {
	FileManagerId id = FileManagerId.create(UUID.randomUUID().toString());
	FileManagerName name = FileManagerName.create(UUID.randomUUID().toString());
	FileManagerDetails details = FileManagerDetails.create(UUID.randomUUID().toString());
	FileManagerObjectId objectId = FileManagerObjectId.create(UUID.randomUUID().toString());
	FileManagerObjectName objectName = FileManagerObjectName.create(UUID.randomUUID().toString());
	FileManagerOriginalName originalName = FileManagerOriginalName.create(UUID.randomUUID().toString());
	FileManagerMimeType mimeType = FileManagerMimeType.create(UUID.randomUUID().toString());
	FileManagerSize size = FileManagerSize.create(99853L);
	FileManagerPath path = FileManagerPath.create(UUID.randomUUID().toString());
	FileManagerUri uri = FileManagerUri.create(UUID.randomUUID().toString());
	FileManagerIsPublic isPublic = FileManagerIsPublic.create(true);
	FileManagerCreatedBy createdBy = FileManagerCreatedBy.create(UUID.randomUUID().toString());
	FileManagerTenant tenant = FileManagerTenant.create(UUID.randomUUID().toString());
	FileManagerAggregate aggregateFileManagerAggregate = new FileManagerAggregate(id, name, details, objectId, objectName, originalName, mimeType, size, path, uri, isPublic, createdBy, tenant);
	assertThat(aggregateFileManagerAggregate.getId()).isNotNull();
	assertThat(aggregateFileManagerAggregate.getId()).isEqualTo(id);
	assertThat(aggregateFileManagerAggregate.getName()).isEqualTo(name);
	assertThat(aggregateFileManagerAggregate.getDetails()).isEqualTo(details);
	assertThat(aggregateFileManagerAggregate.getObjectId()).isEqualTo(objectId);
	assertThat(aggregateFileManagerAggregate.getObjectName()).isEqualTo(objectName);
	assertThat(aggregateFileManagerAggregate.getOriginalName()).isEqualTo(originalName);
	assertThat(aggregateFileManagerAggregate.getMimeType()).isEqualTo(mimeType);
	assertThat(aggregateFileManagerAggregate.getSize()).isEqualTo(size);
	assertThat(aggregateFileManagerAggregate.getPath()).isEqualTo(path);
	assertThat(aggregateFileManagerAggregate.getUri()).isEqualTo(uri);
	assertThat(aggregateFileManagerAggregate.getIsPublic()).isEqualTo(isPublic);
	assertThat(aggregateFileManagerAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateFileManagerAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		FileManagerIdNotValid error = assertThrows(FileManagerIdNotValid.class, () -> FileManagerId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_name_is_invalid() {
		FileManagerNameNotValid error = assertThrows(FileManagerNameNotValid.class, () -> FileManagerName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
		}

}
