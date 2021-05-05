package com.example.androidtechnicaltest.viewmodel;

import android.text.TextUtils;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidtechnicaltest.model.User;
import com.example.androidtechnicaltest.util.Utils;

public class LoginViewModel extends ViewModel {
    public String validateUser(String email, String password) {
        Log.d("email "+email,"pass "+password);
        if (TextUtils.isEmpty(email)) {
            return "Enter an E-Mail Address";
        }
        else if (!Utils.isEmailValid(email)) {
            return "Enter a Valid E-mail Address";
        }
        else if (TextUtils.isEmpty(password)) {
            return "Enter a Password";
        }
        else if (!Utils.isPasswordLengthGreaterThan8(password)) {
            return "Enter at least 8 Digit password";
        }
        return null;
    }

}
