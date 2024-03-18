package innim.fo.api.sys.common;

import lombok.Getter;

import javax.management.loading.MLetContent;

@Getter
public enum SuccessCode {
    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NO_CONTENT(204, "No Content"),
    UNAUTHORIZED(401, "Unauthorized");

    private final int code;
    private final String message;

    SuccessCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
