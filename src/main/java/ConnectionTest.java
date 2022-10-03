import DTO.CommentDto;
import DTO.PostDto;
import DTO.PostReqDto;
import retrofit.ConnectionTestApi;
import retrofit.ConnectionTestApiCaller;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

public class ConnectionTest {
    public static void main(String[] args) {
        final ConnectionTestApi apiService = ConnectionTestApiCaller.getApiService();
        final Call<List<PostDto>> allPosts =
                apiService.getAllPosts();

        final Call<PostDto> post =
                apiService.getPost(1l);

        final Call<List<CommentDto>> comments = apiService.getComments(1l);

        final PostReqDto postReqDto = new PostReqDto();
        postReqDto.setUserId(1);
        postReqDto.setTitle("test title");
        postReqDto.setBody("Test Body");
        final Call<PostDto> writePost = apiService.writePost(postReqDto);
        try {
            final List<PostDto> body = allPosts.execute().body();
            final PostDto postDto = post.execute().body();
            System.out.println("id : " + postDto.getId());
            System.out.println("user id : " + postDto.getUserId());
            System.out.println("title : " + postDto.getTitle());
            System.out.println("body : " + postDto.getBody());

            final List<CommentDto> commentsDto = comments.execute().body();

            for (var comment:
                 commentsDto) {
                System.out.println("=================");
                System.out.println(comment.getId());
                System.out.println(comment.getEmail());
                System.out.println(comment.getName());
                System.out.println(comment.getBody());
                System.out.println(comment.getPostId());
            }

            final PostDto writeResult = writePost.execute().body();

            System.out.println("id : " + writeResult.getId());
            System.out.println("user id : " + writeResult.getUserId());
            System.out.println("title : " + writeResult.getTitle());
            System.out.println("body : " + writeResult.getBody());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
