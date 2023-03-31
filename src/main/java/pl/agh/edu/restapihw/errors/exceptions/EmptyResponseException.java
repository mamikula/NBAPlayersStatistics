package pl.agh.edu.restapihw.errors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason=" Empty response ")  // 404
public class EmptyResponseException extends RuntimeException{
}
