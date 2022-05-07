package com.example.kosharyan.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.kosharyan.adapter.CategoryFromServerRecyclerAdapter;
import com.example.kosharyan.adapter.CostomerFromServerRecyclerAdapter;
import com.example.kosharyan.adapter.NewsListFromServerRecyclerAdapter;
import com.example.kosharyan.api.ApiClient;
import com.example.kosharyan.api.ApiInterface;
import com.example.kosharyan.model.Category;
import com.example.kosharyan.adapter.CategoryRecyclerAdapter;
import com.example.kosharyan.adapter.CostomerRecyclerAdapter;
import com.example.kosharyan.model.News;
import com.example.kosharyan.adapter.NewsListRecyclerAdapter;
import com.example.kosharyan.R;
import com.example.kosharyan.model.home.CustomerResponse;
import com.example.kosharyan.model.news.NewsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentNewsList extends Fragment {
    SearchView searchView;
    RecyclerView recyclerViewCategory;

  CategoryFromServerRecyclerAdapter adapterCategory;
    NewsListFromServerRecyclerAdapter adapterNewsList;
    CostomerRecyclerAdapter adapterCostomer;

    RecyclerView recyclerViewnews;

    ApiInterface request;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_news_list, container, false);
        searchView=view.findViewById(R.id.searchview);
        recyclerViewCategory=view.findViewById(R.id.fragment_news_list_category);
        recyclerViewnews=view.findViewById(R.id.recycler_news);
searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
});
       // setupRecycler4();
        getNewsFromServer();
        getCustomerFromServer();
       // setupRecyclerNews();
        return view;
    }


    void getCustomerFromServer(){

        request= ApiClient.getRetrofit().create(ApiInterface.class);

        request.getNewsFromServer().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                try {
                    if (response.isSuccessful()){

                      //  Log.i("kk","respone count is "+response.body().getCustomer().size());
                        adapterCategory= new CategoryFromServerRecyclerAdapter(response.body(),requireActivity());

                        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);

                        recyclerViewCategory.setLayoutManager(layoutManager);
                        recyclerViewCategory.setAdapter(adapterCategory);


                    }else {

                        Log.i("kk","respone is not success ");
                    }
                }catch (Exception e){
                    Log.i("kk",e.getMessage());

                }


            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

            }
        });


    }

    void setupRecycler4(){
            ArrayList<Category> categories= new ArrayList<>();

            Category category1=new Category("تکنولوژی");
        Category category2=new Category("آی تی ");
        Category category3=new Category("فرهنگی");
        Category category4=new Category("علمی");
        Category category5=new Category("فناوری");
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        categories.add(category5);

        //adapterCategory= new CategoryRecyclerAdapter(categories, requireActivity());

            LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);

            recyclerViewCategory.setLayoutManager(layoutManager);
            recyclerViewCategory.setAdapter(adapterCategory);
        }
    void setupRecyclerNews(){
        ArrayList<News>news=new ArrayList<>();
        News news1=new News("اپل با قابلیت جدید به بازار آمد این قابلیت تشخیص فرد مرده از زنده میباشد که با بهره گیری از هوش مصنوعی این قابلیت را اضافه کرد.","https://digiato.com/wp-content/uploads/2021/08/ios-siri-mac-mac-os.jpg","آی تی لند");
        News news2=new News("ظرفیت پذیرش دانشجو در 12 موسسه وابسته به دستگاههای اجرایی صفرشد.درپی این خبر بسیاری از دانشگاهها به اعتراض علیه این اقدام پرداختند.","https://tvu.ac.ir/cache/2/attach/201904/160578_3049684212_320_214.jpg","فنی نیوز");
        News news3=new News("الجی محصولات خودرا به بازار با قیمت بالایی وارد کرد درپی واردکردن این محصولات گرانی هریک از کالاها چشمگیر وتوجه صادرکنندگان را به خود جلب کرد.","https://cdn01.zoomit.ir/2021/8/oled-ipads-and-mackbook-pro-copy-1200x800.jpg?w=768","کالا لند");
        News news4=new News("چین مراقبت از داده های کاربران را در دست اقدام قرار دا.درپی خطری که دسترسی اطلاعات را هدف قرارداده بود چین با اقدامی سریع مراقبت از داده کاربران رو مورد بررسی قرارداد..","https://www.itmen.ir/images/docs/000277/n00277024-b.jpg","نیوزلند");
        news.add(news1);
        news.add(news2);
        news.add(news3);
        news.add(news4);
      //  adapterNewsList =new NewsListRecyclerAdapter(requireActivity(),news);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewnews.setLayoutManager(layoutManager);
        recyclerViewnews.setAdapter(adapterNewsList);
    }

    void getNewsFromServer(){

        request= ApiClient.getRetrofit().create(ApiInterface.class);

        request.getNewsFromServer().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                try {
                    if (response.isSuccessful()){

                        Log.i("ff","respone count is "+response.body().getNews().size());
                        adapterNewsList= new NewsListFromServerRecyclerAdapter(requireActivity(),response.body());

                        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);

                        recyclerViewnews.setLayoutManager(layoutManager);
                        recyclerViewnews.setAdapter(adapterNewsList);


                        //setup recycler category
                        adapterCategory= new CategoryFromServerRecyclerAdapter(response.body(),requireActivity());

                        LinearLayoutManager layoutManager2 = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);

                        recyclerViewnews.setLayoutManager(layoutManager);
                        recyclerViewnews.setAdapter(adapterNewsList);


                    }else {

                        Log.i("kk","respone is not success ");
                    }
                }catch (Exception e){
                    Log.i("kk",e.getMessage());

                }


            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

            }
        });


    }}