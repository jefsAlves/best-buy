package com.alvesjefs.orders.services.exceptions;

import java.io.Serializable;

public class NumberNotFoundException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	public NumberNotFoundException() {
	}

	public NumberNotFoundException(String name) {

	}
}
