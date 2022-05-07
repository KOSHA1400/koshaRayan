package com.example.kosharyan.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kosharyan.adapter.CostomerFromServerRecyclerAdapter;
import com.example.kosharyan.api.ApiClient;
import com.example.kosharyan.api.ApiInterface;
import com.example.kosharyan.model.Costomer;
import com.example.kosharyan.model.LessonTitel;
import com.example.kosharyan.R;
import com.example.kosharyan.adapter.TakhasosRecyclerAdapter;
import com.example.kosharyan.model.home.CustomerResponse;
import com.limerse.slider.ImageCarousel;
import com.limerse.slider.listener.CarouselListener;
import com.limerse.slider.model.CarouselItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentHome extends Fragment {
    ImageCarousel slider;
    Toolbar toolbar;
    TakhasosRecyclerAdapter adapter2;
    RecyclerView recyclerView2;
    RecyclerView recyclerView;
    CostomerFromServerRecyclerAdapter adapter;


    ApiInterface request;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        slider = view.findViewById(R.id.carousel);
        toolbar = view.findViewById(R.id.toolbar);
        recyclerView2=view.findViewById(R.id.recycler_takhasos);
        recyclerView=view.findViewById(R.id.recycler);

        setupSlider();


        getCustomerFromServer();

        setupRecycler2();
      //  setupRecycler();

        return view;


    }

    void setupRecycler2(){
        ArrayList<LessonTitel> lessonTitels= new ArrayList<>();

        LessonTitel lessonTitel1=new LessonTitel("طراحی وب سایت") ;
        LessonTitel lessonTitel2=new LessonTitel("طراحی اپلیکیشن") ;
        LessonTitel lessonTitel3=new LessonTitel("آموزش") ;
        lessonTitels.add(lessonTitel1);
        lessonTitels.add(lessonTitel2);
        lessonTitels.add(lessonTitel3);
        adapter2= new TakhasosRecyclerAdapter(requireActivity(),lessonTitels);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);

        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setAdapter(adapter2);
    }



    void getCustomerFromServer(){

        request= ApiClient.getRetrofit().create(ApiInterface.class);

        request.getCustomersFromServer().enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                try {
                    if (response.isSuccessful()){

                        Log.i("kk","respone count is "+response.body().getCustomer().size());
                        adapter= new CostomerFromServerRecyclerAdapter(requireActivity(),response.body());

                        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);

                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(adapter);


                    }else {

                        Log.i("kk","respone is not success ");
                    }
                }catch (Exception e){
                    Log.i("kk",e.getMessage());

                }


            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t) {

            }
        });


    }


    void  setupRecycler(){

        ArrayList<Costomer> customers= new ArrayList<>();


        Costomer costomer1 =new Costomer("کیهان کالا","شرکت ما در کوتاه ترین زمان اماده پاسخ است","https://resi.ze-robot.com/dl/4k/4k-desktop-wallpaper.-1920%C3%971200.jpg");
        Costomer costomer2 =new Costomer("شرکت نوافرین","شرکت جهت کسب وکار وایده یابی میباشد","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyXeoRVJs-pMUbAIjpW2RREiHCnWZf6qbe8no-4xD8FRFHVGIfGf4ud1XBrYXjrJVjxLo&usqp=CAU");
        Costomer costomer3 =new Costomer("شرکت رایان","شرکت ما در حوزه آموزش وانجام پروژه میباشد","https://i.pinimg.com/originals/e6/a2/64/e6a26413583096e8b321fea6bcd41f9e.jpg");
        customers.add(costomer1);
        customers.add(costomer2);
        customers.add(costomer3);

        //adapter= new CostomerRecyclerAdapter(requireActivity(),customers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    void setupSlider(){
        slider.registerLifecycle(getLifecycle());


        ArrayList<CarouselItem> itemList =new ArrayList<>();


        request= ApiClient.getRetrofit().create(ApiInterface.class);

        request.getCustomersFromServer().enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                try {
                    if (response.isSuccessful()){

                        Log.i("kk","respone count is "+response.body().getCustomer().size());

                        for (int i=0;i<response.body().getCustomer().size();i++){
                            itemList.add(new CarouselItem(response.body().getEslider().get(i).getUrl()));

                        }




                    }else {

                        Log.i("kk","respone slider is not success ");
                    }
                }catch (Exception e){
                    Log.i("kk",e.getMessage());

                }


            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t) {

            }
        });






        //itemList.add(new CarouselItem("https://images.all-free-download.com/images/wallpapers_large/mercedes_benz_future_bus_2016_17479.jpg", "کوشا رایان(عکسهای تستی)"));
        //itemList.add(new CarouselItem("https://img.freepik.com/free-photo/world-smile-day-emojis-arrangement_23-2149024491.jpg?size=338&ext=jpg","کوشا رایان(عکسهای تستی1)"));
        //itemList.add(new CarouselItem("https://images.wallpapersden.com/image/wxl-pyrenees-france_66809.jpg","کوشا رایان(عکسهای تستی3)"));

        slider.setData(itemList);

        slider.setCarouselListener(new CarouselListener() {
            @Override
            public ViewBinding onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
                return null;
            }

            @Override
            public void onBindViewHolder(ViewBinding viewBinding, CarouselItem carouselItem, int i) {

            }

            @Override
            public void onClick(int i, CarouselItem carouselItem) {

                Toast.makeText(requireActivity(),"item "+i+"clicked",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(int i, CarouselItem carouselItem) {

            }
        });
    }
}