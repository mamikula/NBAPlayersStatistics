package pl.agh.edu.restapihw.errors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value= HttpStatus.NOT_FOUND, reason=" Statistics not found ")  // 500

public class StatsNotFoundException extends RuntimeException{
}
