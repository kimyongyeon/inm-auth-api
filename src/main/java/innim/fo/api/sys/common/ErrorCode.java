package innim.fo.api.sys.common;

import lombok.Getter;

@Getter
public enum ErrorCode {

    SUCCESS(0, "Success"),
    INTERNAL_SERVER_ERROR(1, "Internal server error"),
    INVALID_PARAMETER(2, "Invalid parameter"),
    INVALID_REQUEST(3, "Invalid request");
    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }



}
