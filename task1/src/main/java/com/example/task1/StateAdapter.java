package com.example.task1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import models.Vehicle;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {


    final private List<Vehicle> vehicles;
    final private LayoutInflater inflater;
    final private Context context;

    public StateAdapter(List<Vehicle> vehicleList, Context contextForLayoutInflater, Context contextForGlide) {
        this.vehicles = vehicleList;
        this.inflater = LayoutInflater.from(contextForLayoutInflater);
        this.context = contextForGlide;
    }

    @NonNull
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateAdapter.ViewHolder holder, int position) {
        Vehicle vehicle1 = vehicles.get(position);
        Glide.with(context).load(vehicle1.getImage()).into(holder.carImage);
        holder.carTitle.setText(vehicle1.getTitle());
        holder.carDescription.setText(vehicle1.builder());


    }

    @Override
    public int getItemCount() {
        return vehicles.size();

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView carImage;
        TextView carTitle;
        TextView carDescription;

        ViewHolder(View view) {
            super(view);
            carImage = view.findViewById(R.id.al_car_logo);
            carTitle = view.findViewById(R.id.al_title);
            carDescription = view.findViewById(R.id.al_description);
        }

    }
}
