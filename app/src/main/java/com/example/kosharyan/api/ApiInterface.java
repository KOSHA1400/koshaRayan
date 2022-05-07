package com.example.kosharyan.api;

import com.example.kosharyan.model.eftekharat.EftekharResponse;
import com.example.kosharyan.model.followQuestion.FollowQuestionModel;
import com.example.kosharyan.model.gallery.PicResponse;
import com.example.kosharyan.model.ghavanin.GhavaninResponse;
import com.example.kosharyan.model.home.CustomerResponse;
import com.example.kosharyan.model.member.MemberResponse;
import com.example.kosharyan.model.news.NewsResponse;
import com.example.kosharyan.model.Mahsolat.ProductResponse;
import com.example.kosharyan.model.porsesh.PorseshResponse;
import com.example.kosharyan.model.tamas.TamasResponse;
import com.example.kosharyan.model.tamasbama.TamasbamaResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    //ارتباط با سرور و دریافت اطلاعات


    @GET("home.php")
    Call<CustomerResponse> getCustomersFromServer();




    @GET("news.php")
    Call<NewsResponse> getNewsFromServer( ) ;

    @GET("eftekhar.php")
    Call<EftekharResponse> getEftekharFromServer( ) ;

    @GET("member.php")
    Call<MemberResponse> getMemberFromServer( ) ;

    @GET("product.php")
    Call<ProductResponse> getProductFromServer( ) ;
    @GET("tamasbama.php")
    Call<TamasbamaResponse> getTamasFromServer( ) ;
@POST("tamas.php")
@FormUrlEncoded
    Call<TamasResponse> sendTamasForm(@Field("insert") String insert,@Field("name") String name,@Field("email") String email,@Field("mobile") String mobile,@Field("creat") String creat,@Field("message") String message);

    @GET("gallery.php")
    Call<PicResponse> getPictureFromServer( ) ;

    @GET("rules.php")
    Call<GhavaninResponse> getGhavaninFromServer( ) ;


    @POST("follow_question.php")
    @FormUrlEncoded
    Call<FollowQuestionModel> followQuestionRequest(@Query("code_r") String code ) ;

    @POST("porseshform.php")

    @FormUrlEncoded
    Call<PorseshResponse> sendPorseshForm(@Field("title") String title,@Field("email") String email,@Field("name") String name,@Field("body") String body);

}

