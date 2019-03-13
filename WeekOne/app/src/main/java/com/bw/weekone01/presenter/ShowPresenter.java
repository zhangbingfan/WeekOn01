package com.bw.weekone01.presenter;

import com.bw.weekone01.bean.Data;
import com.bw.weekone01.model.ShowModel;
import com.bw.weekone01.view.ShowView;

import java.util.ArrayList;

public class ShowPresenter {

    private final ShowModel model;
    private final ShowView showView;

    //    在构造方法中实例化model和view
    public ShowPresenter(ShowView view) {
        model = new ShowModel();
        showView = view;
    }

    public void show() {
        model.showData();
        model.setOnShowClickLisenter(new ShowModel.onShowClickLisenter() {
            @Override
            public void onResult(ArrayList<Data> result) {
                showView.view(result);
            }
        });
    }
}
