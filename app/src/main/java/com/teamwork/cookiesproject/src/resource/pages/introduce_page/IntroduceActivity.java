package com.teamwork.cookiesproject.src.resource.pages.introduce_page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.teamwork.cookiesproject.R;
import com.teamwork.cookiesproject.src.resource.adapters.introduce_adapter.IntroduceAdapter;


public class IntroduceActivity extends AppCompatActivity {
    private ViewPager mIntroduceViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        initViewpager();
    }

    private void initViewpager() {
        IntroduceAdapter adapter = new IntroduceAdapter(getSupportFragmentManager());
        mIntroduceViewpager = findViewById(R.id.introduce_viewpager);
        mIntroduceViewpager.setAdapter(adapter);
    }
}