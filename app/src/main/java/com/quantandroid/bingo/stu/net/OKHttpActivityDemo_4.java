package com.quantandroid.bingo.stu.net;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.quantandroid.bingo.stu.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpActivityDemo_4 extends AppCompatActivity {

     Button btnRequest;
     Button btnNext;
     TextView tvData;

     OkHttpClient client;
     String jsonData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo4);
        btnRequest = findViewById(R.id.btn_request);
        btnNext = findViewById(R.id.btn_next);
        tvData = findViewById(R.id.tv_netdata);


        client = new OkHttpClient(); //新建一个OKhttp客户端实例

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //网络请求由于过于耗时需在子线程执行
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendHttpRequest();
                    }
                }).start();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //如果目前未请求数据仍为空 则弹出提示并不执行跳转
                if (jsonData==null){
                    Toast.makeText(OKHttpActivityDemo_4.this,"数据为空，请先请求",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(OKHttpActivityDemo_4.this,GsonActivityDemo_5.class);
                intent.putExtra("jsonData",jsonData);
                startActivity(intent);
            }
        });
}

    private void sendHttpRequest() {
        //构建一条简单的GET请求
        Request request = new Request.Builder()
                .url("http://245z3l3522.qicp.vip/YBD/disc/getArticleList.do")
                .build();
        try {
            //客户端发送请求并等待接收Response对象

            //同步写法
            Response response = client.newCall(request).execute(); //
            String responseData = response.body().string();
            jsonData = responseData;
            //接受数据传递到ui界面上
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvData.setText(responseData);
                }
            });
            Log.d("OKHttpRequest",responseData);


        } catch (IOException e) {
            e.printStackTrace();
        }



//        //异步监听写法
//        Call call = client.newCall(request);
//
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String jsonData = response.body().string();
//            }
//        });
    }
}
