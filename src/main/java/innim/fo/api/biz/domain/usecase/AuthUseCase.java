package innim.fo.api.biz.domain.usecase;


import innim.fo.api.biz.dto.auth.AuthDtoRequest;
import innim.fo.api.biz.dto.auth.AuthDtoResponse;

import java.util.List;

public interface AuthUseCase {
    List<AuthDtoResponse> findAllProduct();
    AuthDtoResponse findByIdProduct(AuthDtoRequest authDtoRequest);
}
