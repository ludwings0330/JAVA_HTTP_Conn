package retrofit;

import DTO.CommentDto;
import DTO.PostDto;
import DTO.PostReqDto;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ConnectionTestApi {
    @GET("/posts")
    Call<List<PostDto>> getAllPosts();

    @GET("/posts/{id}")
    Call<PostDto> getPost(@Path("id") Long id);

    @GET("/comments")
    // /cooments?postId=?
    Call<List<CommentDto>> getComments(@Query("postId") long postId);

    @POST("/posts")
    @Headers({
            "Content-type: application/json",
            //"key: value" // add another header
    })
    Call<PostDto> writePost(@Body PostReqDto postReqDto);
}
