package com.quanquan.checkboxandrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.recyclerview)
    RecyclerView recyclerView;

    @OnClick(R.id.btn)
    public void onDeleteClick() {
        Log.e("sunchangquan", adapter.getSeletorDataPos().toString());
        datas.removeAll(adapter.getSeletorData());
        adapter = new Base1Adapter(this, datas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    int i;

    @OnClick(R.id.btn_add)
    public void onAddData() {
        Person person = new Person("兴化" + i, "");
        i++;
        adapter.addData(person);
    }

    @OnClick(R.id.btn_show)
    public void onShowData() {
        List<Person> seletorData = adapter.getSeletorData();
        Log.e("sunchangquan", seletorData.toString());
    }

    private Base1Adapter adapter;

    List<Person> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add(new Person("帅比权" + i, ""));
        }
        adapter = new Base1Adapter(this, datas);
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
}


