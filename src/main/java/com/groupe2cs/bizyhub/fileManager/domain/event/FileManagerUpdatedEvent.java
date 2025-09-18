package com.groupe2cs.bizyhub.fileManager.domain.event;

	import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileManagerUpdatedEvent implements Serializable {

    private FileManagerId id;
    private FileManagerName name;
    private FileManagerDetails details;
    private FileManagerObjectId objectId;
    private FileManagerObjectName objectName;
    private FileManagerOriginalName originalName;
    private FileManagerMimeType mimeType;
    private FileManagerSize size;
    private FileManagerPath path;
    private FileManagerUri uri;
    private FileManagerIsPublic isPublic;
    private FileManagerCreatedBy createdBy;
    private FileManagerTenant tenant;



}
