package com.example.kosharyan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kosharyan.adapter.CategoryFromServerRecyclerAdapter;
import com.example.kosharyan.adapter.ProductFromServerRecyclerAdapter;
import com.example.kosharyan.api.ApiClient;
import com.example.kosharyan.api.ApiInterface;
import com.example.kosharyan.model.Mahsolat.ProductResponse;
import com.example.kosharyan.model.Product;
import com.example.kosharyan.R;
import com.example.kosharyan.model.news.NewsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentProduct extends Fragment {
    RecyclerView recyclerView5;
    ProductFromServerRecyclerAdapter adapterProduct;
    RecyclerView recyclerView6;
    ApiInterface request;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_product, container, false);
        recyclerView5=view.findViewById(R.id.recycler_product);

      //  setupRecycler5();
        getProductFromServer();
        return view;

    }

    void getProductFromServer(){

        request= ApiClient.getRetrofit().create(ApiInterface.class);

        request.getProductFromServer().enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                try {
                    if (response.isSuccessful()){

                        //  Log.i("kk","respone count is "+response.body().getCustomer().size());
                        adapterProduct= new ProductFromServerRecyclerAdapter(requireActivity(),response.body());

                        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);

                        recyclerView5.setLayoutManager(layoutManager);
                        recyclerView5.setAdapter(adapterProduct);


                    }else {

                        Log.i("kk","respone is not success ");
                    }
                }catch (Exception e){
                    Log.i("kk",e.getMessage());

                }


            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {

            }
        });


    }
    void setupRecycler5(){
        ArrayList<Product> products= new ArrayList<>();

      Product product1=new Product("https://www.parandco.com/images/parand/software-collection/king/55/king-55-adobe-2021.jpg","نرم افزارهای Adobe 2021","نرم افزارهای Adobe 2021 با پشتیبانی از زبان فارسی") ;
      Product product2=new Product("https://www.parandco.com/images/parand/parand-software-collection-version-56.jpg", "KING 56 برترین مجموعه از نرم افزارهای ","مجموعه نرم افزاری KING، به عنوان آپدیت ترین و جامع ترین مجموعه نرم افزاری در بازار ایران، شامل بیش از ۱۱۰۰ برنامه کاربردی و تخصصی جدید به همراه مجموعه ای ارزشمند از دروس منتخب آموزشی شرکت کوشارایان بوده که کلیه نیازهای نرم افزاری شما را برطرف خواهد نمود.") ;
      Product product3=new Product("https://www.parandco.com/images/parand/learning/Photoshop-Pro-main-mix.jpg","نرم افزار فتوشاپ","یکی از برترین نرم افزار های حرفه ای جهت یادگیری فتوشاپ میباشد.") ;
      Product product4=new Product("https://www.parandco.com/images/parand/software-collection/king/53/king-53-bootable.jpg","نرم افزارهای Bootable","یکی از ویژگی های مجموعه نرم افزاری کینگ، Bootable بودن کلیه دیسک های مجموعه بوده تا شما بتوانید بسیاری از نیازهای خود را در خارج از محیط سیستم عامل نیز انجام دهید.  ") ;

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

       // adapter5= new ProductsRecyclerAdapter(requireActivity(),products);

      //  LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);

      //  recyclerView5.setLayoutManager(layoutManager);
       // recyclerView5.setAdapter(adapter5);
}

}