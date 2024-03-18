package innim.fo.api.biz.domain.model.auth.request;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SelectAuthRequest(
        Integer id,
        String photoUrl,
        String title,
        String description,
        BigDecimal price,
        BigDecimal salePrice,
        BigDecimal salePercentage,
        BigDecimal rating,
        Integer reviewCount
) {
}
