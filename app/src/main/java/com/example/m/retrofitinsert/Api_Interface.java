package com.example.m.retrofitinsert;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api_Interface {

    @POST("testRetrofitApi/insertRecord.php")
    @FormUrlEncoded
    Call<Post> savePost(
            @Field("username") String username,
            @Field("password") String password
    );
}

