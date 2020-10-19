package com.teamwork.businessguideprofortiktok.src.utils;

import android.service.autofill.RegexValidator;

public class Validations {
    public boolean validCellPhone(String number) {
        return android.util.Patterns.PHONE.matcher(number).matches();
    }
}

