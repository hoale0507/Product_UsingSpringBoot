package com.codegym.product_usingspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ControllerAdvice
public class ExceptionHelper {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
//		for (ObjectError error: ex.getBindingResult().getAllErrors()) {
//			String fieldName = ((FieldError)error).getField();
//			String errorMessage = error.getDefaultMessage();
//			errors.put(fieldName,errorMessage);
//		}
////		List<ObjectError> errors1 = ex.getBindingResult().getAllErrors();
////		for (int i = 0; i < ex.getBindingResult().getAllErrors().size(); i++) {
////			String fieldName = ((FieldError)errors1.get(i)).getField();
////			String errorMessage = errors1.get(i).getDefaultMessage();
////			errors.put(fieldName,errorMessage);
////		}

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
