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
import com.example.newex.Model.serviceData;
import com.example.newex.R;
import com.example.newex.ServiceDetails;
import com.example.newex.roomdetails;


import java.util.List;

public class serviceAdapter extends RecyclerView.Adapter<serviceAdapter.serviceViewHolder> {

    Context context;
    List<serviceData> serviceDataList;

    public serviceAdapter(Context context, List<serviceData> serviceDataList) {
        this.context = context;
        this.serviceDataList = serviceDataList;
    }

    @NonNull
    @Override
    public serviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.service_item, parent, false);

        return new serviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull serviceViewHolder holder, int position) {
        holder.serviceName.setText(serviceDataList.get(position).getServiceName());
        holder.serviceImage.setImageResource(serviceDataList.get(position).getImageUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(context,ServiceDetails.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return serviceDataList.size();
    }

    public static final class serviceViewHolder extends RecyclerView.ViewHolder{

        ImageView serviceImage;
        TextView serviceName;

        public serviceViewHolder(@NonNull View itemView) {
            super(itemView);

            serviceImage = itemView.findViewById(R.id.service_image);
            serviceImage = itemView.findViewById(R.id.service_name);


        }
    }
}
