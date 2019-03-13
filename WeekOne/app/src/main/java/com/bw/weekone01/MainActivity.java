package com.bw.weekone01;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bw.weekone01.adapter.MyAdapter;
import com.bw.weekone01.bean.Data;
import com.bw.weekone01.presenter.ShowPresenter;
import com.bw.weekone01.view.ShowView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ShowView {

    private RecyclerView rel;
    private ShowPresenter presenter;
    private MyAdapter adapter;
    private int page=1;
    private SwipeRefreshLayout sr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        rel = findViewById(R.id.rel);
        sr = findViewById(R.id.sr);

        //布局管理器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        rel.setLayoutManager(linearLayoutManager);
        //实例化presenter
        presenter = new ShowPresenter(this);
        //传参
        presenter.show();
    }

    @Override
    public void view(ArrayList<Data> result) {
        adapter = new MyAdapter(MainActivity.this,result);
        Log.i("xxx","result"+result.get(0).getCommodityId());
        rel.setAdapter(adapter);
    }
}
