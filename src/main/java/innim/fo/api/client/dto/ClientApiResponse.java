package innim.fo.api.client.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientApiResponse <T> {

    private int statusCode;
    private String message;
    private T data;
}
