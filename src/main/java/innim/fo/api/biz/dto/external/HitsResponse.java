package innim.fo.api.biz.dto.external;

import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HitsResponse {
    private int total;
    private int totalHits;
    private List<Hit> hits;
}
