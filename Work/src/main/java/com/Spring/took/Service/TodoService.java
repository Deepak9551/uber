package com.Spring.took.Service;


import com.Spring.took.Entity.Root;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface TodoService {
    @GET("/todos/{id}")
    Call<Root> getTodobyid(@Path( "id") String id);
}
