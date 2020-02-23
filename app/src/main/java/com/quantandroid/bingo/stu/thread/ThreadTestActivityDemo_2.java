package com.quantandroid.bingo.stu.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.quantandroid.bingo.stu.R;

public class ThreadTestActivityDemo_2 extends AppCompatActivity {
    Button btnTest;

    //此处Handler的使用方法部分情况下会引发应用内存泄漏，优化方法和原理看博客https://blog.csdn.net/alex01550/article/details/82744191
//
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    //代码
                    //Toast.makeText(ThreadTestActivityDemo_2.this,"iammtoast",Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    //
                    break;

            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        btnTest = findViewById(R.id.btn_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(ThreadTestActivityDemo_2.this,"测试Toast",Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //子线程进行如下ui操作程序会崩溃
                        // Toast.makeText(ThreadTestActivityDemo_2.this,"测试Toast",Toast.LENGTH_SHORT).show();

//                        /*方法1 -利用运行在主线程的handler来接收信息并执行ui操作。*/
//
                       //  handler.sendEmptyMessage(1);
                     //   handler有多个参数支持传发消息， int what、int arg1、int arg2、Object obj
//
                        Message msg  = Message.obtain(); //创建一个空的Message对象
                        msg.what = 1; //msg的标识
                        msg.arg1 = 0; //msg携带的第一个值
                        msg.arg2 = 1; //msg携带的第二个值
                        msg.obj = new Object(); //msg.obj 还可以携带Object类;
                        //msg还可以利用bundle携带一些复杂的数据，如下
                        Bundle bundle = new Bundle();
                        String[] arr = {"","",""};

                        bundle.putStringArray("StringArray",arr);
                        msg.setData(bundle);

                       // handler.sendMessage(msg);//发送消息
                       // handler.sendEmptyMessage(1);
//
//                        handler.sendMessageDelayed(msg,1000); //延时1000毫秒发送
//
//
//
                        /*方法2 -runOnUiThread() 该方法原理仍是利用handler实现*/
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Toast.makeText(ThreadTestActivityDemo_2.this,"测试Toast",Toast.LENGTH_SHORT).show();
//                            }
//                        });
                    }
                }).start();
            }
        });
    }

}
