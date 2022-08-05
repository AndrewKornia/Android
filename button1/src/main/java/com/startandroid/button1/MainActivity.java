package com.startandroid.button1;

import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.view.View.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button buttSave;
    Button buttDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        buttSave = findViewById(R.id.buttSave);
        buttDelete = findViewById(R.id.buttDelete);

        OnClickListener clickSave = new OnClickListener() {
            @Override
            public void onClick(View v) {
                        textView.setText(editText.getText().toString());
                }

        };
        OnClickListener clickDelete = new OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
            }
        };
        buttSave.setOnClickListener(clickSave);
        buttDelete.setOnClickListener(clickDelete);





    }
}