package com.alvesjefs.products.services.exceptions;

import java.io.Serializable;

public class ProductAlreadyExistsException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	public ProductAlreadyExistsException() {
	}

	public ProductAlreadyExistsException(String msg) {
		super(msg);
	}

}
