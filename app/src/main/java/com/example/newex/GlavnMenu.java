package com.example.newex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newex.Adapter.recentsAdapter;
import com.example.newex.Adapter.serviceAdapter;
import com.example.newex.Model.recentsData;
import com.example.newex.Model.serviceData;

import java.util.ArrayList;
import java.util.List;

public class GlavnMenu extends AppCompatActivity {
    RecyclerView recentRecycler, serviceRecycler;
    com.example.newex.Adapter.recentsAdapter recentsAdapter;
    com.example.newex.Adapter.serviceAdapter serviceAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glavn_menu);
        List<recentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new recentsData("Одноместный номер", R.drawable.hotel1));
        recentsDataList.add(new recentsData("Двухместный номер", R.drawable.hotel2));
        recentsDataList.add(new recentsData("Комплекс на 5 ночей", R.drawable.hotel3));

        setRecentRecycler(recentsDataList);


    List<serviceData> serviceDataList = new ArrayList<>();
        serviceDataList.add(new serviceData("СПА комплекс", R.drawable.hotel1));
        serviceDataList.add(new serviceData("Фитнесс зал", R.drawable.hotel2));
        serviceDataList.add(new serviceData("Библиотека", R.drawable.hotel3));

        setServiceRecycler(serviceDataList);


    }

    private  void setRecentRecycler(List<recentsData> recentsDataList){

        recentRecycler = findViewById(R.id.recents_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new recentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }
    private  void setServiceRecycler(List<serviceData> serviceDataList){

        serviceRecycler = findViewById(R.id.service_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        serviceRecycler.setLayoutManager(layoutManager);
        serviceAdapter = new serviceAdapter(this, serviceDataList);
        serviceRecycler.setAdapter(recentsAdapter);

    }
    public void moreRooms_btn(View view){
        Intent intent= new Intent(GlavnMenu.this,roomdetails.class);
        startActivity(intent);
    }

    public  void  logout(View view){
        Intent intent = new Intent(GlavnMenu.this,MainActivity.class);
    }

}
