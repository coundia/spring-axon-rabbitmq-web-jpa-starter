package com.groupe2cs.bizyhub.shared.infrastructure.ia;


import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;

import java.util.List;

interface IAService {
	String generateResponse(String prompt);

	String getCategory(String type, String userId,  String categoryName,String tenant);
}
