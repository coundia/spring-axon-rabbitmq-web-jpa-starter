package com.groupe2cs.bizyhub.sales.application.query;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindAllSaleUserQuery {

private final int page;
private final int limit;
private final MetaRequest metaRequest;

}
