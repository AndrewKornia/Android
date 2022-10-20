package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class LogPassword extends AppCompatActivity {

    EditText personName;
    EditText password;
    private SharedPreferences pref;
    private static final String nameContainers = "saveLogAndPass";
    private final String key = "keyName";
    private final String key1 = "keyPassword";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_password);
        init();
        getLogAndPass();
    }

    /**
     * Метод обрабатывет нажатие кнопки и созраняет результат в nameContainers
     * @param view параметр
     */
    public void clickEnter(View view) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key,personName.getText().toString());
        editor.putString(key1,password.getText().toString());
        editor.apply();
        getToast();
    }

    /**
     * Метод создают обект класса SharedPreferences
     */
    private void init(){
        pref = getSharedPreferences(nameContainers,MODE_PRIVATE);
        personName = findViewById(R.id.PersonName);
        password = findViewById(R.id.Password);
    }

    /**
     *Метод возвращает сохраненную информацию в поля для ввода
     */
    private void getLogAndPass() {
        personName.setText(pref.getString(key, "Введите логин"));
        password.setText(pref.getString(key1, "Введите пароль"));
    }
    /**
     * Метод создают всплывающее сообщение
     */
    void getToast(){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Вход разрешен", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}