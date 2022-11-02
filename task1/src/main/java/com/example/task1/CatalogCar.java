package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import models.Vehicle;

public class СatalogCar extends AppCompatActivity {

    TextView login;
    List<Vehicle> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.al_login);
        login.setText(getIntent().getStringExtra("login"));
        ViewModelsVehicle vehicle = new ViewModelsVehicle();
        vehicle.addVehicle();
        list = vehicle.getVehicleList();
        RecyclerView recyclerView = findViewById(R.id.list_vehicle);
        StateAdapter adapter = new StateAdapter(list,this);
        recyclerView.setAdapter(adapter);




    }
}