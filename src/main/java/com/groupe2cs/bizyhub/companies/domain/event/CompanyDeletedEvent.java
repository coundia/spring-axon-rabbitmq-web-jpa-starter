package com.groupe2cs.bizyhub.companies.domain.event;

import com.groupe2cs.bizyhub.companies.domain.valueObject.CompanyId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDeletedEvent implements Serializable {


	private CompanyId id;

}
