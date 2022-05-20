package com.example.newex.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newex.Model.recentsData;
import com.example.newex.R;
import com.example.newex.roomdetails;

import java.util.List;

public class recentsAdapter extends RecyclerView.Adapter<recentsAdapter.RecentsViewHolder> {
    Context context;
    List<recentsData> recentsDataList;

    public  recentsAdapter(Context context, List<recentsData> recentsDataList){
        this.context=context;
        this.recentsDataList=recentsDataList;
    }

    @NonNull
    @Override
    public RecentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.recents_row_item,parent,false);
        return new RecentsViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsViewHolder holder, int position) {
        holder.RoomTitle.setText(recentsDataList.get(position).getRoomTitle());
        holder.roomImage.setImageResource(recentsDataList.get(position).getImageUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(context, roomdetails.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recentsDataList.size();
    }

    public  static  final class RecentsViewHolder extends RecyclerView.ViewHolder{

        ImageView roomImage;
        TextView RoomTitle;

        public RecentsViewHolder(@NonNull View itemView) {
            super(itemView);
            roomImage=itemView.findViewById(R.id.service_image);
            RoomTitle=itemView.findViewById(R.id.service_name);
        }
    }
}
