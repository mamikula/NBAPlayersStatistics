package pl.agh.edu.restapihw.errors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason=" Not acceptable season date input ")  // 500

public class WrongSeasonDateException extends RuntimeException{
}
