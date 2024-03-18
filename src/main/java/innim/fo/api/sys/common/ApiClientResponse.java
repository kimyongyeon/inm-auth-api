package innim.fo.api.sys.common;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiClientResponse<T> {
    private int statusCode;
    private String message;
    private T data;
}
