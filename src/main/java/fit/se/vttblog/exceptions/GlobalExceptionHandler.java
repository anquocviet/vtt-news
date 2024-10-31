package fit.se.vttblog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @description
 * @author: vie
 * @date: 31/10/24
 */
@ControllerAdvice
public class GlobalExceptionHandler {

   private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

   @ExceptionHandler(AppException.class)
   public ResponseEntity<ErrorResponse> handleAppException(AppException e) {
      logger.log(Level.SEVERE, "App error: ", e);

      ErrorResponse errorResponse = new ErrorResponse(e.getCode(), e.getMessage());
      return ResponseEntity.status(e.getCode()).body(errorResponse);
   }

   @ExceptionHandler(BindException.class)
   public ResponseEntity<ErrorResponse> handleBindException(BindException e) {
      logger.log(Level.SEVERE, "Validation error: ", e);

      ErrorResponse errorMessage = new ErrorResponse(400, e.getAllErrors().get(0).getDefaultMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
   }

   @ExceptionHandler(Exception.class)
   public ResponseEntity<ErrorResponse> handleUnwantedException(Exception e) {
      logger.log(Level.SEVERE, "Unknown error: ", e);

      ErrorResponse errorResponse = new ErrorResponse(500, "Có lỗi xảy ra, vui lòng thử lại sau");
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
   }

}