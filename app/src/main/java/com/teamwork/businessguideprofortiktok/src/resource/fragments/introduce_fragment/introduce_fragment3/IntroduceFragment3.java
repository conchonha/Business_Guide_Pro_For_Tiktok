package com.teamwork.businessguideprofortiktok.src.resource.fragments.introduce_fragment.introduce_fragment3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.compoments.TextChangeListener;
import com.teamwork.businessguideprofortiktok.src.resource.pages.introduce_page.IntroduceActivity;
import com.teamwork.businessguideprofortiktok.src.resource.pages.login_page.LoginFacebookActivity;
import com.teamwork.businessguideprofortiktok.src.utils.Validations;


public class IntroduceFragment3 extends Fragment {
    private View view;
    private EditText mEdittextEmail, mEdittextPass;
    private Button ButtonGetCreate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_introduce3, container, false);
        init();
        setOnclickListener();
        return view;
    }

    private void setOnclickListener() {
        mEdittextEmail.addTextChangedListener(new TextChangeListener(mEdittextEmail) {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                super.onTextChanged(s, start, before, count);
                if (!Validations.isValidPhoneNumber(mEdittextEmail.getText().toString()) ||
                        !Validations.isEmailValid(mEdittextEmail.getText().toString())) {
                    mEdittextEmail.setError("Invalid phone number or email");
                }
            }
        });

        mEdittextPass.addTextChangedListener(new TextChangeListener(mEdittextPass) {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                super.onTextChanged(s, start, before, count);
                if (!Validations.isPasswordValid(mEdittextPass.getText().toString())) {
                    mEdittextPass.setError("Invalid password");
                }
            }
        });
        ButtonGetCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginFacebookActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        mEdittextEmail = view.findViewById(R.id.email);
        mEdittextPass = view.findViewById(R.id.pass);
        ButtonGetCreate = view.findViewById(R.id.btn_get_create);
    }
}
