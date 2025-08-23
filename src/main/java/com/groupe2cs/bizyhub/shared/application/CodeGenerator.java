package com.groupe2cs.bizyhub.shared.application;


import java.util.concurrent.ThreadLocalRandom;

public class CodeGenerator {
	public String numeric(int length) {
		if (length <= 0) throw new IllegalArgumentException("length must be > 0");
		char[] digits = new char[length];
		ThreadLocalRandom r = ThreadLocalRandom.current();
		for (int i = 0; i < length; i++) digits[i] = (char) ('0' + r.nextInt(10));
		return new String(digits);
	}
}
