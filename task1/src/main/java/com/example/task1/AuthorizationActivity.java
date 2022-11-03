package com.example.task1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
     * Метод предупреждает о некорректных введеных данных и в случае их отсутсвия переходит на другой экран сохраняя инфо о пользавателе
     */
    private void authorization() {
        if (!isLoginValid()) {
            aa_errorLogin = findViewById(R.id.aa_errorLogin);
            aa_errorLogin.setVisibility(View.VISIBLE);
            inputLogin.addTextChangedListener(watcherLogin);

        } else if (!isPasswordValid()) {
            aa_errorPassword = findViewById(R.id.aa_errorPassword);
            aa_errorPassword.setVisibility(View.VISIBLE);
            inputPassword.addTextChangedListener(watcherPassword);

        } else {
            saveInfoAboutUser();
            createActivity();
        }
    }

    /**
     * Сохранение инфо о пользвователе
     */
    private void saveInfoAboutUser() {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(keyForLogin, inputLogin.getText().toString());
        editor.putString(keyForPassword, inputPassword.getText().toString());
        editor.apply();
    }

    /**
     * Создание новаго Activity
     */
    private void createActivity() {
        Intent intent = new Intent(this, CatalogCar.class);
        intent.putExtra("login",pref.getString(keyForLogin,""));
        startActivity(intent);


    }

    /**
     * Метод создают обект класса SharedPreferences и устанвливает слушатель нажатия на кнопку
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
     * Проверка валидноссти поля Login
     *
     * @return true/false
     */
    private boolean isLoginValid() {
        return inputLogin.getText().toString().length() >= 8;
    }

    /**
     * Проверка валидноссти поля Password
     *
     * @return true/false
     */
    private boolean isPasswordValid() {
        return inputPassword.getText().toString().length() >= 8;
    }


    /**
     * Создание обстрктного класса TextWatcher и реализауия метода onTextChanged  для inputLogin
     */
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

    /**
     * Создание обстрктного класса TextWatcher и реализация метода onTextChanged для inputPassword
     */
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


