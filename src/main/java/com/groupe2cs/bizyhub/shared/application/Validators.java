package com.groupe2cs.bizyhub.shared.application;

public class Validators {


	public static boolean isValidMail(String email) {
		if (email == null || email.isBlank()) {
			return false;
		}
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		return email.matches(emailRegex);
	}

	public static boolean isValidPhone(String phone) {
		if (phone == null || phone.isBlank()) {
			return false;
		}
		String phoneRegex = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";
		return phone.matches(phoneRegex);
	}


}
