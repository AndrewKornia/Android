package com.startandroid.task1;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOut =findViewById(R.id.tvOut);
        btnOk = findViewById(R.id.btnOk);
        btnCancel=findViewById(R.id.btnCancel);

        OnClickListener Ok = new OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOut.setText("click");

            }

        };

        btnOk.setOnClickListener(Ok);

        OnClickListener cancel = new OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOut.setText("Cancel");
            }
        };
        btnCancel.setOnClickListener(cancel);






    }
}