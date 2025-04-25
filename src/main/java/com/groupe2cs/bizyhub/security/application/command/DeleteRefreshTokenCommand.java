package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import java.util.Date;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteRefreshTokenCommand implements Serializable {
@TargetAggregateIdentifier
	private RefreshTokenId id;
 	
 	
 	
 	
 	


}
