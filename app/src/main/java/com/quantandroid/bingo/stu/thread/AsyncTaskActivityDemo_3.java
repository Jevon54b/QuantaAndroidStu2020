package com.quantandroid.bingo.stu.thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.quantandroid.bingo.stu.R;

    public class AsyncTaskActivityDemo_3 extends AppCompatActivity {

    TextView tvProgress;
    Button btnDownload;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo3);
        btnDownload = findViewById(R.id.btn_download);
        tvProgress = findViewById(R.id.tv_progress);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownLoadTask().execute();
            }
        });
    }



    class DownLoadTask extends AsyncTask<Void,Integer,Boolean>{

        /*设定一段时间来模拟下载任务*/
        private int doDownload(long startTime,long endTime){
            long curTime = System.currentTimeMillis();
            double percentFloat = ((double)(curTime-startTime)/(double)(endTime-startTime));
            String percentString = String.valueOf(percentFloat);
            int percent = getPercentFromString(percentString);
            Log.d("DownLoadTask","下载进度"+percent);
            return percent;
         }


         /*从小数string中分离出小数点后前两位*/
         private int getPercentFromString(String percentString){
            int percent;
            if (percentString.length()<3){
                percent = 0;
            }else if(percentString.length()<4){
                percent = Integer.parseInt(percentString.substring(2,3)+"0");
            } else{
                if (percentString.substring(2,4).equals("0E")){
                    percent = 0;
                    return percent;
                }
                percent = Integer.parseInt(percentString.substring(2,4));
            }
            return percent;
         }

        //该方法在子线程执行，用来执行耗时任务
        @Override
        protected Boolean doInBackground(Void... voids) {
            int downloadPercent = 0;
            long startTime = System.currentTimeMillis();
            long endTime = startTime+5*1000;
            while(true){
                downloadPercent = doDownload(startTime,endTime); //模拟下载
                publishProgress(downloadPercent);  //利用publishProgress调起onProgressUpdate更新进度。
                    if (downloadPercent>=99){
                    break;
                }
            }
            return true;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvProgress.setText("下载开始");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tvProgress.setText(values[0]+"%");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            tvProgress.setText("下载完成100%");
        }
    }
}
