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
import com.teamwork.businessguideprofortiktok.src.resource.pages.introduce_page.IntroduceActivity;
import com.teamwork.businessguideprofortiktok.src.resource.pages.login_page.LoginFacebookActivity;


public class IntroduceFragment3 extends Fragment {
    private View view;
    private EditText EdittextEmaiil, EdittextPass;
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
        ButtonGetCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginFacebookActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        EdittextEmaiil = view.findViewById(R.id.email);
        EdittextPass = view.findViewById(R.id.pass);
        ButtonGetCreate = view.findViewById(R.id.btn_get_create);
    }
}
