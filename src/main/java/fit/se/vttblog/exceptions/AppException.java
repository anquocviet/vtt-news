package fit.se.vttblog.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description
 * @author: vie
 * @date: 31/10/24
 */
@Getter
@AllArgsConstructor
public class AppException extends RuntimeException {
   private final int code;
   private final String message;
}
