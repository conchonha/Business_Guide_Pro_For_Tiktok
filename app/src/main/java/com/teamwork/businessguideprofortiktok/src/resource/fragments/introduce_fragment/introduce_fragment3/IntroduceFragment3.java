package com.teamwork.businessguideprofortiktok.src.resource.fragments.introduce_fragment.introduce_fragment3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.teamwork.businessguideprofortiktok.R;


public class IntroduceFragment3 extends Fragment {
    private View view;
    private EditText EdittextEmaiil, EdittextPass;
    private Button ButtonGetCreate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_introduce3, container, false);
        init();
        return view;
    }

    private void init() {
        EdittextEmaiil = view.findViewById(R.id.email);
        EdittextPass = view.findViewById(R.id.pass);
        ButtonGetCreate = view.findViewById(R.id.btn_get_create);
    }
}
