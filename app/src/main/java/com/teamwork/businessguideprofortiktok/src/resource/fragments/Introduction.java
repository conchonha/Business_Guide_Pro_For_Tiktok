package com.teamwork.businessguideprofortiktok.src.resource.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.resource.pages.introduce_page.IntroduceActivity;


public class Introduction extends Fragment {
    private View view;
    private Button BtnSingIn, BtnGetCreate;
    private Handler handler;
    private Runnable runnable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_introduce1, container, false);
        intview();
        listenerOnclicked();
        return view;
    }

    private void listenerOnclicked() {
        BtnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translateViewPager(2);
            }
        });
        BtnGetCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translateViewPager(1);
            }
        });
    }

    public void translateViewPager(final int intdex) {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                IntroduceActivity.mIntroduceViewpager.setCurrentItem(intdex);
            }
        };
        handler.postDelayed(runnable, 100);
    }

    private void intview() {
        BtnSingIn = view.findViewById(R.id.btn_sing_in);
        BtnGetCreate = view.findViewById(R.id.btn_get_create);
    }
}
