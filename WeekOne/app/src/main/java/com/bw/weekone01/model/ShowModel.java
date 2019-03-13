package com.bw.weekone01.model;

import android.os.Handler;
import android.os.Message;

import com.bw.weekone01.bean.Data;
import com.bw.weekone01.bean.Json;
import com.bw.weekone01.utils.ShoUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ShowModel {
    String url="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword";
    public interface onShowClickLisenter
    {
        void onResult(ArrayList<Data> result);
    }
    private onShowClickLisenter onShowClickLisenter;


    public void setOnShowClickLisenter(ShowModel.onShowClickLisenter onShowClickLisenter) {
        this.onShowClickLisenter = onShowClickLisenter;
    }

    private Handler handler=new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case 0:
                     String obj  = (String) msg.obj;
                     Gson gson = new Gson();
                     Json json = gson.fromJson(obj, Json.class);
                     ArrayList<Data> result = json.getResult();
                      onShowClickLisenter.onResult(result);
                    break;
            }
        }
    };
    public void showData() {
        ShoUtils.getInstance().doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 String json = response.body().string();

                final Message message = new Message();
                message.what=0;
                message.obj=json;

                //发送消息
                handler.sendMessage(message);
            }
        });
    }
}
