package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class AuthorizationClass extends AppCompatActivity {

    EditText inputLogin;
    EditText inputPassword;
    private SharedPreferences pref;
    private static final String nameContainers = "saveLogAndPass";
    private final String keyForLogin = "keyName";
    private final String keyForPassword = "keyPassword";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_authorization);
        initUI();
    }

    /**
     * Метод назначает кнопке 
     */
    private void authorization(){
        findViewById(R.id.aa_buttonEnter).setOnClickListener(view->{
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString(keyForLogin, inputLogin.getText().toString());
                    editor.putString(keyForPassword, inputPassword.getText().toString());
                    editor.apply();
                    showToast();
                }
                );
    }
    
    /**
     * Метод создают обект класса SharedPreferences
     */
    private void initUI(){
        pref = getSharedPreferences(nameContainers,MODE_PRIVATE);
        inputLogin = findViewById(R.id.aa_login);
        inputPassword = findViewById(R.id.aa_password);
        authorization();
        setLogAndPass();
    }

    /**
     *Метод возвращает сохраненную информацию в поля для ввода
     */
    private void setLogAndPass() {
        inputLogin.setText(pref.getString(keyForLogin, ""));
        inputPassword.setText(pref.getString(keyForPassword, ""));
    }
    /**
     * Метод создают всплывающее сообщение
     */
    void showToast(){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Вход разрешен", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}