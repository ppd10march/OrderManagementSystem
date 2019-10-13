package com.hcl.ordermanagement.exception;

import com.hcl.ordermanagement.dto.OrderDTO;

public class CustomErrorType extends OrderDTO {

	private String errorMessage;

	public CustomErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	
}
