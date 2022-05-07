package com.example.kosharyan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kosharyan.model.Category;
import com.example.kosharyan.adapter.CategoryRecyclerAdapter;
import com.example.kosharyan.model.Costomer;
import com.example.kosharyan.adapter.CostomerRecyclerAdapter;
import com.example.kosharyan.R;
import com.example.kosharyan.model.news.NewsResponse;

import java.util.ArrayList;


public class FragmentAlbum extends Fragment {

    RecyclerView recyclerView4;
    CategoryRecyclerAdapter adapterCategory;
    CostomerRecyclerAdapter adapter;
    RecyclerView recyclerView;
    RecyclerView recyclerGallery;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_album, container, false);
        recyclerView4 = view.findViewById(R.id.fragment_news_category);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerGallery = view.findViewById(R.id.recycler1);




       // setupRecyclerCatPic();
       // setupRecyclerPic();
      //  setupRecycler();
  return view;
    }

    void setupRecyclerCatPic() {
        ArrayList<Category> categories = new ArrayList<>();

        Category category1 = new Category("آموزشی");
        Category category2 = new Category("فرهنگی");
        Category category3 = new Category("علمی");
        Category category4 = new Category("فناوری");
        Category category5 = new Category("تکنولوژی");
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        categories.add(category5);
        adapterCategory = new CategoryRecyclerAdapter(categories, requireActivity());

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView4.setLayoutManager(layoutManager);
        recyclerView4.setAdapter(adapterCategory);
    }
    void setupRecycler() {

        ArrayList<Costomer> customers = new ArrayList<>();


        Costomer costomer1 = new Costomer("کیهان کالا", "شرکت ما در کوتاه ترین زمان اماده پاسخ است", "https://digiato.com/wp-content/uploads/2021/08/ios-siri-mac-mac-os.jpg");
        Costomer costomer2 = new Costomer("شرکت نوافرین", "شرکت جهت کسب وکار وایده یابی میباشد", "https://www.parandco.com/images/parand/parand-software-collection-version-56.jpg");
        Costomer costomer3 = new Costomer("شرکت رایان", "شرکت ما در حوزه آموزش وانجام پروژه میباشد", "https://i.pinimg.com/originals/e6/a2/64/e6a26413583096e8b321fea6bcd41f9e.jpg");
        customers.add(costomer1);
        customers.add(costomer2);
        customers.add(costomer3);

        adapter = new CostomerRecyclerAdapter(requireActivity(), customers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
    void setupRecyclerPic() {

        ArrayList<Costomer> customers1 = new ArrayList<>();


        Costomer costomer1 = new Costomer("کیهان کالا", "شرکت ما در کوتاه ترین زمان اماده پاسخ است", "https://digiato.com/wp-content/uploads/2021/08/ios-siri-mac-mac-os.jpg");
        Costomer costomer2 = new Costomer("شرکت نوافرین", "شرکت جهت کسب وکار وایده یابی میباشد", "https://www.parandco.com/images/parand/parand-software-collection-version-56.jpg");
        Costomer costomer3 = new Costomer("شرکت رایان", "شرکت ما در حوزه آموزش وانجام پروژه میباشد", "https://i.pinimg.com/originals/e6/a2/64/e6a26413583096e8b321fea6bcd41f9e.jpg");
        customers1.add(costomer1);
        customers1.add(costomer2);
        customers1.add(costomer3);

        adapter = new CostomerRecyclerAdapter(requireActivity(), customers1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerGallery.setLayoutManager(layoutManager);
        recyclerGallery.setAdapter(adapter);


    }
}