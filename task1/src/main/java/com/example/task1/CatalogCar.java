package com.example.task1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import models.Vehicle;

public class CatalogCar extends AppCompatActivity {

    TextView login;
    List<Vehicle> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
        createCatalog();
        createAdapter();


    }

    private void initUI() {
        login = findViewById(R.id.al_login);
        login.setText(getIntent().getStringExtra("login"));

    }

    private void createCatalog() {
        ViewModelsVehicle vehicle = new ViewModelsVehicle();
        vehicle.addVehicle();
        list = vehicle.getVehicleList();
    }

    private void createAdapter() {
        RecyclerView recyclerView = findViewById(R.id.list_vehicle);
        StateAdapter adapter = new StateAdapter(list, this, this);
        recyclerView.setAdapter(adapter);

    }


}