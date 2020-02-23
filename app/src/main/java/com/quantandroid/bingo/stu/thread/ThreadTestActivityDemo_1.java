package com.quantandroid.bingo.stu.thread;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.quantandroid.bingo.stu.R;

/*
 * Created by JORDAN on 2020/2/20.
 * Email:1249110047@qq.com
 */
public class ThreadTestActivityDemo_1 extends AppCompatActivity implements  View.OnClickListener{

    Button btnOpenThread1;
    Button btnOpenThread2;
    Button btnOpenThread3;
    Button btnOpenThread4;
    TextView tvTest;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);
        btnOpenThread1 = findViewById(R.id.btn_thread1);
        btnOpenThread2 = findViewById(R.id.btn_thread2);
        btnOpenThread3 = findViewById(R.id.btn_thread3);
        btnOpenThread4 = findViewById(R.id.btn_thread4);
        btnOpenThread1.setOnClickListener(this);
        btnOpenThread2.setOnClickListener(this);
        btnOpenThread3.setOnClickListener(this);
        btnOpenThread4.setOnClickListener(this);

        //lambda表达式
        btnOpenThread4.setOnClickListener((view)->{
            //点击后的代码
        });
    }




    /* 创建子线程的几种写法，存在多种写法，看个人偏好及具体需求做选择*/
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_thread1:
                new MyThread1().start();
                break;
            case R.id.btn_thread2:
                new MyThread2().run();
                break;
            case R.id.btn_thread3:
                new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            //具体代码
                        }
            }.start();
                break;
            case R.id.btn_thread4:
                //匿名接口实现类Runnable
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        //具体代码
//                    }
//                }).start();
                //java8 支持 lambda表达式 匿名接口的简洁写法
                new Thread(()->{
                    //具体代码
                }).start();

                break;
        }
    }
//    /* 继承Thread类  重写run()方法*/
//    class MyThread1 extends  Thread{
//        @Override
//        public void run() {
//            super.run();
//            //执行的代码
//        }
//    }
    class MyThread1 extends Thread{
        @Override
        public void run() {
            super.run();
            //具体代码
        }
    }

    /* 实现Runnable接口  重写run()方法*/
//    class MyThread2 implements Runnable{
//
//        @Override
//        public void run() {
//            //执行代码
//        }
//    }
    class MyThread2 implements  Runnable{

        @Override
        public void run() {
            //具体代码
        }
    }
}
