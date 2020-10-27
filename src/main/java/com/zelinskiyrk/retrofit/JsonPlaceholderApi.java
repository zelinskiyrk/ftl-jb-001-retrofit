package com.zelinskiyrk.retrofit;

import com.zelinskiyrk.retrofit.request.PostCreateRequest;
import com.zelinskiyrk.retrofit.request.PostUpdateRequest;
import com.zelinskiyrk.retrofit.response.AlbumResponse;
import com.zelinskiyrk.retrofit.response.CommentResponse;
import com.zelinskiyrk.retrofit.response.PostResponse;
import com.zelinskiyrk.retrofit.response.UserResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JsonPlaceholderApi {

    @GET("/posts")
    Call<List<PostResponse>> posts();

    @POST("/posts")
    Call<PostResponse> postCreate(@Body PostCreateRequest request);

    @PUT("/posts/{id}")
    Call<PostResponse> postUpdate(@Path ("id") Integer id, @Body PostUpdateRequest request);

    @DELETE("/posts/{id}")
    Call<Void> postDelete(@Path ("id") Integer id);

    @GET("/posts/{id}")
    Call<PostResponse> postWithId(@Path ("id") Integer id);

    @GET("/posts/{id}/comments")
    Call<List<CommentResponse>> postComments(@Path ("id") Integer id);

    @GET("/users")
    Call<List<UserResponse>> users();

    @GET("/users/{id}/albums")
    Call<List<AlbumResponse>> userAlbums(@Path("id") Integer id);

}
