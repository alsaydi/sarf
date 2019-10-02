package sarfwebservice.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InvalidRootException.class)
    public final ResponseEntity<ExceptionResponse> invalidRoot(InvalidRootException ex){
        var exceptionResponse = new ExceptionResponse(  ex.getMessage(), "");

        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RootNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> rootNotFound(RootNotFoundException ex){
        var exceptionResponse = new ExceptionResponse(  ex.getMessage(), "");

        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
