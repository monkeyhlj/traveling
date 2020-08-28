package com.example.administrator.traveling;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";

    TextView t1,t2,t3;
    DBService d=new DBService();
    List<User> list = null;

    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0x00001:
                    if(list != null){
                        for(User u:list){
                            Log.i(TAG, "handleMessage: "+u.toString());
                            t1.setText(u.getUsername());
                            t2.setText(u.getPassword());
                        }
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
    }
    public void func(View view){
        switch (view.getId())
        {
            case R.id.b1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        list=d.getUserData();
                        Message message = new Message();
                        message.what = 0x00001;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
        }
    }


}
