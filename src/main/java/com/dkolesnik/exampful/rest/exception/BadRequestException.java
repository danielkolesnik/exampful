package com.dkolesnik.exampful.rest.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * General exception to be treated as BAD_REQUEST.
 *
 * @author   Daniel A. Kolesnik <daneelkolesnik@gmail.com>
 * @version  0.1.1
 * @since    2020-07-02
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@AllArgsConstructor
public class BadRequestException extends ServerException {

	public BadRequestException(String message) {
		super(message, 400);
	}

	/**
	 * Full API exception constructor
	 *
	 * @param message
	 * @param code
	 */
	public BadRequestException(String message, int code) {
		super(message, code);
	}

}
