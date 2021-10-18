package com.farias.retrofitej1.request;

import com.farias.retrofitej1.modelo.Comment;
import com.farias.retrofitej1.modelo.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Genaro Farias el 18/10/2021.
 * Estudiante de la ULP
 * gfsanluis78@gmail.com
 */

public class ApiClient {

    private static final String URLBASE="https://jsonplaceholder.typicode.com/";    //le pongo el nombre de Url base que es mas informativa, termina en /
    private static  PostInterface postInterface;


    // Construccion del objeto retrofit
    public static PostInterface getMyApiClient(){

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URLBASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        postInterface=retrofit.create(PostInterface.class);

        return postInterface;
    }




    // armar la interface
    public interface  PostInterface{

        @GET("posts")
        Call<List<Post>> obtenerPosts();


        @GET("posts/{id}")
        Call<Post> obtenerPost(@Path("id") int idPost);

        @GET("comments?postId")
        Call<List<Comment>> obtenerComments(@Query("postId") int idPost);

        @POST("posts")
        Call<Post> crearPost(@Body Post post);

    }



}
