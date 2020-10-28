package com.zelinskiyrk.retrofit.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AlbumResponse {
    public int userId;
    public int id;
    public String title;
}
