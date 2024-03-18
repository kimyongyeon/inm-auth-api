package innim.fo.api.biz.dto.auth;

import lombok.*;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthDtoRequest {
    private String username;
    private String password;
}
