package com.groupe2cs.bizyhub.products.domain.exception;

public class PriceNotCorrect extends RuntimeException implements PriceNotCorrectInterface {
    public PriceNotCorrect(String message) {
        super(message);
    }
}
