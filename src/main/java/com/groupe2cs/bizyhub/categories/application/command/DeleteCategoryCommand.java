package com.groupe2cs.bizyhub.categories.application.command;

import com.groupe2cs.bizyhub.categories.domain.valueObject.CategoryId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteCategoryCommand implements Serializable {
	@TargetAggregateIdentifier
	private CategoryId id;


}
