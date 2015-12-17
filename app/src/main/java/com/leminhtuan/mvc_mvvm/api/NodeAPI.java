package com.leminhtuan.mvc_mvvm.api;

import com.leminhtuan.mvc_mvvm.models.User;

import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.Call;

public interface NodeAPI{
    @GET("/users/basil2style")
    Call<User> get(@Query("tagged") String tags);
}
