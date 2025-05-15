package com.groupe2cs.bizyhub.shared.infrastructure.ia;


interface IAService {
	  String generateResponse(String prompt);
	  String getCategory(String type,String userId);
}
