package innim.fo.api.biz.dto.external;


import lombok.*;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hit {
    private int id;
    private String pageURL;
    private String type;
    private String tags;
    private String previewURL;
    private int previewWidth;
    private int previewHeight;
    private String webformatURL;
    private int webformatWidth;
    private int webformatHeight;
    private String largeImageURL;
    private String fullHDURL;
    private String imageURL;
    private int imageWidth;
    private int imageHeight;
    private int imageSize;
    private int views;
    private int downloads;
    private int likes;
    private int comments;
    private int userId;
    private String user;
    private String userImageURL;
}
