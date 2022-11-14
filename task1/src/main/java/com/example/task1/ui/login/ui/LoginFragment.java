package com.example.task1.ui.login.ui;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.task1.R;

public class LoginFragment extends Fragment {

    EditText inputLogin;
    EditText inputPassword;
    TextView fl_errorLogin;
    TextView fl_errorPassword;
    Button fl_enterButton;
    private SharedPreferences pref;
    private static final String nameContainers = "saveLogAndPass";
    private final String keyForLogin = "keyName";
    private final String keyForPassword = "keyPassword";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        inputLogin = view.findViewById(R.id.fl_login);
        inputPassword = view.findViewById(R.id.fl_password);
        fl_errorLogin = view.findViewById(R.id.fl_errorLogin);
        fl_errorPassword = view.findViewById(R.id.fl_errorPassword);
        fl_enterButton = view.findViewById(R.id.fl_buttonEnter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Activity activityStart = createActivity();
        initUI(activityStart);
    }

    /**
     * Метод для получения activity и проверка на null
     *
     * @return activity
     */
    public Activity createActivity() {
        Activity activity = getActivity();
        assert activity != null;
        return activity;
    }

    /**
     * Метод предупреждает о некорректных введеных данных и в случае их отсутсвия переходит на другой fragment
     */
    private void authorization() {
        String login = inputLogin.getText().toString();
        String password = inputPassword.getText().toString();
        login = getLoginIfValid(login);
        password = getPasswordIfValid(password);
        if (login != null && password != null) {
            saveInfoAboutUser(login, password);
            NavHostFragment.findNavController(this).
                    navigate(LoginFragmentDirections.
                            toCatalogCarFragment(pref.getString(keyForLogin, "")));
        }
    }

    /**
     * Сохранение инфо о пользвователе
     */
    private void saveInfoAboutUser(String login, String password) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(keyForLogin, login);
        editor.putString(keyForPassword, password);
        editor.apply();
    }

    /**
     * Метод создают обект класса SharedPreferences и устанвливает слушатель нажатия на кнопку
     */
    private void initUI(Activity activity) {
        pref = activity.getSharedPreferences(nameContainers, MODE_PRIVATE);
        setLogAndPass();
        fl_enterButton.setOnClickListener(view -> {
            authorization();
        });
        inputLogin.addTextChangedListener(watcherLogin);
        inputLogin.addTextChangedListener(watcherLogin);
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
     * @return login\null
     */
    private String getLoginIfValid(String login) {
        if (login.length() > 8) {
            return login;
        }
        fl_errorLogin.setVisibility(View.VISIBLE);
        return null;
    }

    /**
     * Проверка валидноссти поля Password
     *
     * @return password\null
     */
    private String getPasswordIfValid(String password) {
        if (password.length() > 8) {
            return password;
        }
        fl_errorPassword.setVisibility(View.VISIBLE);
        return null;
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
            fl_errorLogin.setVisibility(View.INVISIBLE);
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
            fl_errorPassword.setVisibility(View.INVISIBLE);
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };
}


