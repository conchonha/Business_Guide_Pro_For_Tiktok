package com.teamwork.businessguideprofortiktok.src.resource.fragments.introduce_fragment.introduce_fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.teamwork.businessguideprofortiktok.R;


public class IntroduceFragment2 extends Fragment {
    private View view;
    private RadioButton RadioBtnOption1, RadioBtnOption2;
    private EditText EdittextD, EdittextM, EdittextY, EdittextEmail, EdittextPhone, EdittextPass, EdittextConfirmPass;
    private Button ButtonGetCreate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_introduce2, container, false);
        init();
        return view;
    }

    private void init() {
        RadioBtnOption1 = view.findViewById(R.id.radio_option_1);
        RadioBtnOption2 = view.findViewById(R.id.radio_option_2);
        EdittextD = view.findViewById(R.id.d);
        EdittextM = view.findViewById(R.id.m);
        EdittextY = view.findViewById(R.id.y);
        EdittextEmail = view.findViewById(R.id.email);
        EdittextPhone = view.findViewById(R.id.phonenumber);
        EdittextPass = view.findViewById(R.id.pass);
        EdittextConfirmPass = view.findViewById(R.id.confirmpass);
        ButtonGetCreate = view.findViewById(R.id.btn_create_account);
    }
}
