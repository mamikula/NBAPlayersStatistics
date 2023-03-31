package pl.agh.edu.restapihw.errors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason="Something went wrong on the server side")  // 500
public class PlayerNotFoundException extends RuntimeException{
}
