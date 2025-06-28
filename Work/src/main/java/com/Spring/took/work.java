package com.Spring.took;

import com.Spring.took.Entity.Root;
import com.Spring.took.Service.TodoService;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class work {
    public static void main(String[] args)  {
        OkHttpClient client = new OkHttpClient();


            Request request = new Request.Builder().url("https://jsonplaceholder.typicode.com/todos/1").build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (!response.isSuccessful()){
                System.out.println("Something went wrong");
            }

            System.out.println(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            response.close();
        }


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();
        TodoService todoService = retrofit.create(TodoService.class);
        try {
            Root body = todoService.getTodobyid("3").execute().body();
            System.out.println(body);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    }

