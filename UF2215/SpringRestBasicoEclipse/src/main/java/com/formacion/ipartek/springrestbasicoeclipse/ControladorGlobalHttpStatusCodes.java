package com.formacion.ipartek.springrestbasicoeclipse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControladorGlobalHttpStatusCodes extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	//@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> notFound(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "{}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(ex, bodyOfResponse, 
          headers, HttpStatus.NOT_FOUND, request);
	}
}
