package com.example.task1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class AuthorizationActivity extends AppCompatActivity {

    EditText inputLogin;
    EditText inputPassword;
    TextView aa_errorLogin;
    TextView aa_errorPassword;
    private SharedPreferences pref;
    private static final String nameContainers = "saveLogAndPass";
    private final String keyForLogin = "keyName";
    private final String keyForPassword = "keyPassword";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        initUI();


    }

    /**
     * Метод назначает кнопке
     */
    private void authorization() {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(keyForLogin, inputLogin.getText().toString());
        editor.putString(keyForPassword, inputPassword.getText().toString());
        editor.apply();
        validation();

    }


    /**
     * Метод создают обект класса SharedPreferences
     */
    private void initUI() {
        pref = getSharedPreferences(nameContainers, MODE_PRIVATE);
        inputLogin = findViewById(R.id.aa_login);
        inputPassword = findViewById(R.id.aa_password);
        setLogAndPass();
        findViewById(R.id.aa_buttonEnter).setOnClickListener(view -> {
            authorization();
        });


    }

    /**
     * Метод возвращает сохраненную информацию в поля для ввода
     */
    private void setLogAndPass() {

        inputLogin.setText(pref.getString(keyForLogin, ""));
        inputPassword.setText(pref.getString(keyForPassword, ""));


    }

    /**
     * Метод создают всплывающее сообщение
     */
    void showToast() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Вход разрешен", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    private void validation() {
        boolean chekLengthKeyForLogin = pref.getString(keyForLogin, "").length() < 8;
        boolean chekLengthKeyForPassword = pref.getString(keyForPassword, "").length() < 8;
        if (chekLengthKeyForLogin) {
            aa_errorLogin = findViewById(R.id.aa_errorLogin);
            aa_errorLogin.setVisibility(View.VISIBLE);


        } else if (chekLengthKeyForPassword) {
            aa_errorPassword = findViewById(R.id.aa_errorPassword);
            aa_errorPassword.setVisibility(View.VISIBLE);


        } else {
            showToast();
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);


        }
        inputLogin.addTextChangedListener(watcherLogin);
        inputPassword.addTextChangedListener(watcherPassword);


    }

    private final TextWatcher watcherLogin = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            aa_errorLogin.setVisibility(View.INVISIBLE);

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private final TextWatcher watcherPassword = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            aa_errorPassword.setVisibility(View.INVISIBLE);

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

}


