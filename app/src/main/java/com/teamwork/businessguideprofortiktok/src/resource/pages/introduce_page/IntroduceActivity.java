package com.teamwork.businessguideprofortiktok.src.resource.pages.introduce_page;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.resource.adapters.introduce_adapter.IntroduceAdapter;
import java.util.ArrayList;

public class IntroduceActivity extends AppCompatActivity {
    private RecyclerView mRecyclerview;
    private IntroduceAdapter mAdapter;
    private ArrayList<Integer>mArrayLayout;
    private TextView mTxtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        init();
        initRecyclerview();
        listennerOnclickedView();
    }

    private void listennerOnclickedView() {
        mTxtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scroollView(7);
            }
        });
    }

    private void init() {
        mTxtLogin = findViewById(R.id.txt_login);
        mArrayLayout = new ArrayList<>();
        mArrayLayout.add(R.layout.layout_introduce0);
        mArrayLayout.add(R.layout.layout_introduce1);
        mArrayLayout.add(R.layout.layout_introduce2);
        mArrayLayout.add(R.layout.layout_introduce3);
        mArrayLayout.add(R.layout.layout_introduce4);
        mArrayLayout.add(R.layout.layout_introduce5);
        mArrayLayout.add(R.layout.layout_introduce6);
        mArrayLayout.add(R.layout.layout_introduce7);
    }

    public void scroollView(int position){
//        Toast.makeText(this, "co click", Toast.LENGTH_SHORT).show();
        mRecyclerview.scrollToPosition(position);
    }

    private void initRecyclerview() {
        mAdapter = new IntroduceAdapter(mArrayLayout,IntroduceActivity.this);
        mRecyclerview = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

}