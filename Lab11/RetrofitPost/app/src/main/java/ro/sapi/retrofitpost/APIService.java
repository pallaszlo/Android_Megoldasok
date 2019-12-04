package ro.sapi.retrofitpost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);

    @POST("/posts")
    Call<Post> savePost(@Body Post post);

    @FormUrlEncoded
    @POST("login.inc3.php")
    public Call<LoginResponse> loginUser(@Field("username") String userNameValue,
                                           @Field("password") String passwordValue);

}