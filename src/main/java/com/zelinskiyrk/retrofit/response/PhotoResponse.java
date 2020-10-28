package com.zelinskiyrk.retrofit.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class PhotoResponse {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;
}
