package innim.fo.api.sys.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BizControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiClientResponse<?>> handleException(Exception e) {
        return ResponseEntity.status(500).body(
                ApiClientResponse.builder()
                        .statusCode(ErrorCode.INTERNAL_SERVER_ERROR.getCode())
                        .message(e.getMessage()).build());
    }
}
