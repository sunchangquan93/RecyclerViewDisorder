package com.quanquan.checkboxandrecyclerview.second;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.quanquan.checkboxandrecyclerview.R;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private ArrayList<UserBean> mLists = new ArrayList<>();
    private MyAdapter adapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, null);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new RecyclerViewDivider(LinearLayoutManager.VERTICAL, Color.GRAY));
        //到达边缘时，再滑动会出现渐变颜色，此设置会取消渐变色
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        adapter.setOnDKClickListener(new MyAdapter.OnDKClickListener() {
            @Override
            public void onDKClick(View view, UserBean user, int position) {
                toast(user.userName + ">>>" + position);
            }
        });
        init();
    }
    private void init() {
        UserBean user = null;
        for (int i = 0; i < 50; i++) {
            user = new UserBean();
            user.isSelected = false;//未选中
            user.userName = "电鳗枕头,look for die ---" + i;
            this.mLists.add(user);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateList(this.mLists);
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
