package com.quantandroid.bingo.stu.net;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.quantandroid.bingo.stu.R;
import com.quantandroid.bingo.stu.bean.Article;
import com.quantandroid.bingo.stu.bean.BaseResponse;

import java.util.List;

public class GsonActivityDemo_5 extends AppCompatActivity {

    Button btnParse;


    String jsonData;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5);
        btnParse = findViewById(R.id.btn_parse);
        Intent intent = getIntent();
        jsonData = intent.getStringExtra("jsonData");
        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseJsonDataWithGson();
            }
        });

    }

    private void parseJsonDataWithGson() {
        Gson gson = new Gson();
        BaseResponse<List<Article>> baseResponse = gson.fromJson(jsonData,new TypeToken<BaseResponse<List<Article>>>(){}.getType());
        List<Article> articleList = baseResponse.getData();

        for (Article article:articleList){
            Log.d("GSONParseArticle", "id is: "+article.getId());
            Log.d("GSONParseArticle", "title is: "+article.getTitle());
            Log.d("GSONParseArticle", "author is: "+article.getAuthor());
            Log.d("GSONParseArticle", "pic is: "+article.getPic());
        }

    }
}
