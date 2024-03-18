package innim.fo.api.client.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventResponse {
    private long id;
    private String photoUrl;
    private String title;
    private String description;
}
