package com.example.androidtechnicaltest.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.androidtechnicaltest.R;
import com.example.androidtechnicaltest.databinding.ActivityLoginBinding;
import com.example.androidtechnicaltest.viewmodel.LoginViewModel;

import java.util.Objects;


public class LoginActivity  extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(((LoginActivity) this).getSupportActionBar()).setTitle("Login");
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);
        binding.setLifecycleOwner(this);
        binding.setLoginScreen(LoginActivity.this);
    }

    public void onClick(View view) {
        closeKeyboard();
        String message = loginViewModel.validateUser(binding.txtEmail.getText().toString(), binding.txtPassword.getText().toString());
        if (message != null && !message.isEmpty()){
            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, MovieActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private void closeKeyboard(){
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}