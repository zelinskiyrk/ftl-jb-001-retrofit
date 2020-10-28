package com.zelinskiyrk.retrofit;

import com.zelinskiyrk.retrofit.request.AlbumCreateRequest;
import com.zelinskiyrk.retrofit.request.AlbumUpdateRequest;
import com.zelinskiyrk.retrofit.request.PostCreateRequest;
import com.zelinskiyrk.retrofit.request.PostUpdateRequest;
import com.zelinskiyrk.retrofit.response.AlbumResponse;
import com.zelinskiyrk.retrofit.response.CommentResponse;
import com.zelinskiyrk.retrofit.response.PostResponse;
import com.zelinskiyrk.retrofit.response.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("START");
        JsonPlaceholderApi api = JsonPlaceholderService.getInstance().getJSONApi();

        System.out.println("-------- POSTS --------");
        List<PostResponse> posts = api.posts().execute().body();
        System.out.println(posts.toString());

        System.out.println("-------- POST CREATE --------");
        PostResponse postCreate = api.postCreate(PostCreateRequest.builder()
                .userId(3)
                .title("New Post")
                .body("News")
                .build()).execute().body();
        System.out.println(postCreate);

        System.out.println("-------- POST UPDATE --------");
        PostResponse postUpdate = api.postUpdate(1, PostUpdateRequest.builder()
                .Id(1)
                .userId(3)
                .title("New Post")
                .body("News")
                .build()).execute().body();
        System.out.println(postUpdate);

        System.out.println("-------- POST DELETE --------");
        Boolean postDelete = api.postDelete(1).execute().isSuccessful();
        System.out.println(postDelete);

        System.out.println("-------- POST With ID --------");
        PostResponse postWithId = api.postWithId(1).execute().body();
        System.out.println(postWithId);

        System.out.println("-------- POST Comments --------");
        List<CommentResponse> commentResponses = api.postComments(1).execute().body();
        System.out.println(commentResponses);

        System.out.println("-------- Users --------");
        List<UserResponse> userResponses = api.users().execute().body();
        System.out.println(userResponses);

        System.out.println("-------- Users Albums --------");
        List<AlbumResponse> albumResponsesByUser = api.userAlbums(1).execute().body();
        System.out.println(albumResponsesByUser);

        Call<List<CommentResponse>> commentCall = api.postComments(1);
        Response<List<CommentResponse>> commentsCallResponse = commentCall.execute();
        if (commentsCallResponse.isSuccessful() && commentsCallResponse.code() == 200) {
            List<CommentResponse> responses = commentsCallResponse.body();
        } else {
            if (commentsCallResponse.code() == 400) {
                String error = commentsCallResponse.errorBody().string();
            } else if (commentsCallResponse.code() == 500) {
                String error = commentsCallResponse.errorBody().string();
            } else if (commentsCallResponse.code() == 403) {
                String error = commentsCallResponse.errorBody().string();
            }
        }

        for (int i = 0; i < 100; i++){
            api.postComments(1).enqueue(new Callback<List<CommentResponse>>() {
                @Override
                public void onResponse(Call<List<CommentResponse>> call, Response<List<CommentResponse>> response) {
                    List<CommentResponse> commentAsyncResponse = response.body();
                }

                @Override
                public void onFailure(Call<List<CommentResponse>> call, Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        }
        System.out.println("passed");

        System.out.println("-------- All Albums --------");
        List<AlbumResponse> allAlbums = api.allAlbums().execute().body();
        System.out.println(allAlbums);

        System.out.println("-------- Album By ID --------");
        AlbumResponse albumById = api.albumById(1).execute().body();
        System.out.println(albumById);

        System.out.println("-------- Album CREATE --------");
        AlbumResponse albumCreate = api.albumCreate(AlbumCreateRequest.builder()
        .userId(1)
        .id(1)
        .title("testTitle").build()).execute().body();
        System.out.println(albumCreate);

        System.out.println("-------- Album UPDATE --------");
        AlbumResponse albumUpdate = api.albumUpdate(1, AlbumUpdateRequest.builder()
        .userId(3)
        .id(1)
        .title("updateTitle")
        .build()).execute().body();
        System.out.println(albumUpdate);

        System.out.println("-------- Album DELETE --------");
        Boolean albumDelete = api.albumDelete(1).execute().isSuccessful();
        System.out.println(albumDelete);
    }

}
