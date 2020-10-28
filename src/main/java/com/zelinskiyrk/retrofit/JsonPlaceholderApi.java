package com.zelinskiyrk.retrofit;

import com.zelinskiyrk.retrofit.request.*;
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

    @GET("/albums")
    Call<List<AlbumResponse>> allAlbums();

    @GET("/albums/{id}")
    Call<AlbumResponse> albumById(@Path("id") Integer id);

    @POST("/albums")
    Call<AlbumResponse> albumCreate(@Body AlbumCreateRequest request);

    @PUT("/albums/{id}")
    Call<AlbumResponse> albumUpdate(@Path("id") Integer id, @Body AlbumUpdateRequest request);

    @DELETE("/albums/{id}")
    Call<Void> albumDelete(@Path("id") Integer id);

    @GET("/users/{id}")
    Call<UserResponse> user(@Path("id") Integer id);

    @POST("/users")
    Call<UserResponse> userCreate(@Body UserCreateRequest request);

    @PUT("/users/{id}")
    Call<UserResponse> userUpdate(@Path("id") Integer id, @Body UserUpdateRequest request);

    @DELETE("/users/{id}")
    Call<Void> userDelete(@Path("id") Integer id);

    @GET("/comments")
    Call<List<CommentResponse>> allComments();

    @GET("/comments/{id}")
    Call<CommentResponse> getCommentById(@Path("id") Integer id);

    @POST("/comments")
    Call<CommentResponse> commentCreate(@Body CommentCreateRequest request);

    @PUT("/comments/{id}")
    Call<CommentResponse> commentUpdate(@Path("id") Integer id, @Body CommentUpdateRequest request);

    @DELETE("/comments/{id}")
    Call<Void> commentDelete(@Path("id") Integer id);

}
