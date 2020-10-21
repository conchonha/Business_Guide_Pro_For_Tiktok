package com.teamwork.businessguideprofortiktok.src.resource.fragments.introduce_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.resource.pages.login_firebase_page.LoginFirebaseActivity;


public class FragmentSlider2 extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_slider2, container, false);
        transactionLogin();
        return view;
    }

    public void transactionLogin(){
        Button btn = view.findViewById(R.id.btnGetStarTed);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LoginFirebaseActivity.class));
                getActivity().finish();
            }
        });

    }

}
