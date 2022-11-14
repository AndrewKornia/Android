package com.example.task1.ui.catalog.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1.R;
import com.example.task1.models.Vehicle;
import com.example.task1.ui.catalog.vm.ViewModelsVehicle;

import java.util.List;

public class CatalogCarFragment extends Fragment {

    TextView login;
    List<Vehicle> list;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalog_car, container, false);
        login = view.findViewById(R.id.fc_login);
        recyclerView = view.findViewById(R.id.fc_list_vehicle);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        login.setText(CatalogCarFragmentArgs.fromBundle(getArguments()).getUserLogin());
        initUI();
    }

    private void initUI() {
        createCatalog();
        createAdapter();
    }

    private void createCatalog() {
        ViewModelsVehicle vehicle = new ViewModelsVehicle();
        vehicle.addVehicle();
        list = vehicle.getVehicleList();
    }

    private void createAdapter() {
        StateAdapter adapter = new StateAdapter(list, getContext(), getContext());
        recyclerView.setAdapter(adapter);

    }


}
