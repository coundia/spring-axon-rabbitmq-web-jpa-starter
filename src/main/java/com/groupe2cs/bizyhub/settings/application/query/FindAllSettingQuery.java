package com.groupe2cs.bizyhub.settings.application.query;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindAllSettingQuery {

private final int page;
private final int limit;
private final MetaRequest metaRequest;

}
