package innim.fo.api.biz.domain.persistence;


import innim.fo.api.biz.domain.model.auth.request.SelectAuthRequest;
import innim.fo.api.biz.domain.model.auth.response.AuthResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthMapper {

//    @Select("SELECT * FROM EVENTS ORDER BY ID DESC")
    List<AuthResponse> selectAllProducts();

//    @Select("SELECT * FROM EVENTS WHERE ID = #{id}")
    AuthResponse selectProductById(SelectAuthRequest request);

}
