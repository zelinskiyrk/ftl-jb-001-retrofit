package com.zelinskiyrk.retrofit.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostUpdateRequest {
    private Integer Id;
    private Integer userId;
    private String title;
    private String body;
}
