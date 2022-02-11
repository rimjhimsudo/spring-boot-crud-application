package bankmanagmentsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice //handle exception globally
public class GlobalExceptionHandler {
    //handle specific exception : you can create more like this
    @ExceptionHandler(ResourceNotfoundException.class)
    //@ExceptionHandler annotated method is only active for that particular Controller
    public ResponseEntity<?> handleResourceNotfoundException(
            ResourceNotfoundException exception, WebRequest webRequest
            ){
        ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    //global handler to all other kind of exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(
            Exception exception, WebRequest webRequest
    ){
        ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
