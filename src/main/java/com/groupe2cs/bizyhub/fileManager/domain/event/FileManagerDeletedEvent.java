package com.groupe2cs.bizyhub.fileManager.domain.event;

import com.groupe2cs.bizyhub.fileManager.domain.valueObject.FileManagerId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileManagerDeletedEvent implements Serializable {


	private FileManagerId id;

}
