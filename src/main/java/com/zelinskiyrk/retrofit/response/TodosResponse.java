package com.zelinskiyrk.retrofit.response;

import lombok.ToString;

@ToString
public class TodosResponse {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
