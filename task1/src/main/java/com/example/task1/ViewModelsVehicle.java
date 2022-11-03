package com.example.task1;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import models.Vehicle;

public class ViewModelsVehicle extends ViewModel {

    private List<Vehicle> vehicleList = new ArrayList<>();

    public List<Vehicle> getVehicleList() {
        return this.vehicleList;
    }

    public void addVehicle() {
        vehicleList.add(new Vehicle("000001", "BMW", "https://picsum.photos/200", 1999, 101.050, "15.700$"));
        vehicleList.add(new Vehicle("000002", "Audi", "https://picsum.photos/200", 2010, 54.050, "45.700$"));
        vehicleList.add(new Vehicle("000003", "CADILLAC", "https://picsum.photos/200", 2019, 20.555, "280.500$"));
        vehicleList.add(new Vehicle("000004", "HUMMER", "https://picsum.photos/200", 1999, 101.050, "15700$"));
        vehicleList.add(new Vehicle("000005", "MAYBACH", "https://picsum.photos/200", 2000, 101.050, "15700$"));
        vehicleList.add(new Vehicle("000006", "PORSCHE", "https://picsum.photos/200", 1994, 101.050, "15700$"));
        vehicleList.add(new Vehicle("000007", "ГАЗ", "https://picsum.photos/200", 2007, 101.050, "4005$"));
    }

}
