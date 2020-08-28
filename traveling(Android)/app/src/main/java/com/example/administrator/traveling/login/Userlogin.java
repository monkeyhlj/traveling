package com.example.administrator.traveling.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.traveling.R;


public class Userlogin extends AppCompatActivity {
    private String TAG = "Userlogin";
    DBService d=new DBService();
    boolean t1,t2;

    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //Log.i(TAG, "handleMessage: "+t);
            switch (msg.what){
                case 0x00001:
                    if(t1) {
                        Toast.makeText(getApplicationContext(),"登录成功！",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Userlogin.this,Search.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"登录失败！",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 0x00002:
                    if(t2) {
                        Toast.makeText(getApplicationContext(),"登录成功！",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Userlogin.this,Backstage.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"登录失败！",Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };

    EditText e1,e2;
    String s1=null;
    String s2=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);

    }

    public void userlog(View view){
        switch (view.getId())
        {
            case R.id.b1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        s1=e1.getText().toString();
                        s2=e2.getText().toString();
                        t1=d.selectUserData(s1,s2);
                        Message message = new Message();
                        message.what = 0x0001;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
            case R.id.b2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        s1=e1.getText().toString();
                        s2=e2.getText().toString();
                        t2=d.selectManagerData(s1,s2);
                        Message message = new Message();
                        message.what = 0x0002;
                        myHandler.sendMessage(message);
                    }
                }).start();
        }
    }

}
