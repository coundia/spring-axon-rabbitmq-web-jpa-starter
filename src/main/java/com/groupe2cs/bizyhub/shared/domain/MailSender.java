package com.groupe2cs.bizyhub.shared.domain;


public interface MailSender {
	void send(String from, String to, String subject, String content);

	boolean isValidEmail(String email);

}

