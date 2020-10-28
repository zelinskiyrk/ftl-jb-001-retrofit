package com.zelinskiyrk.retrofit.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AlbumCreateRequest {
    private String title;
    private int userId;
    private int id;
}
