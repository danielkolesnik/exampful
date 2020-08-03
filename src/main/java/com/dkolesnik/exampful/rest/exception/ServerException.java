package com.dkolesnik.exampful.rest.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

/**
 * General exception to be treated as SERVER_EXCEPTION.
 *
 * @author   Daniel A. Kolesnik <daneelkolesnik@gmail.com>
 * @version  0.1.1
 * @since    2020-07-02
 */
@Setter
@Getter
@NoArgsConstructor
public class ServerException extends RuntimeException {

	/**
	 * Exception code
	 */
	private int code;

	public ServerException(String message) {
		super(message);
	}

	public ServerException(String message, int code) {
		super(message);

		this.code = code;
	}

	@JsonIgnore
	@ApiIgnore
	@Override
	public StackTraceElement[] getStackTrace() {
		return super.getStackTrace();
	}

}
