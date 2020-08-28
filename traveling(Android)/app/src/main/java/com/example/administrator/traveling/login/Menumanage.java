package com.example.administrator.traveling.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.traveling.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Menumanage extends AppCompatActivity {

    Button b1,b2,b3,b4;
    DBService d=new DBService();
    ArrayList<Information> list1,list2;

    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0x00001:
                    Intent intent=new Intent(Menumanage.this,SelectInfo.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("list1",list1);
                       // bundle.putSerializable("list1",(Serializable)list1);
                    intent.putExtras(bundle);
                    startActivity(intent);
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menumanage);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
    }

    public void fun(View view){
        switch (view.getId())
        {
            case R.id.b1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        list1=d.selectinfo();
                        Message message = new Message();
                        message.what = 0x00001;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
            case R.id.b2:
                Intent intent=new Intent(Menumanage.this,QueryInfoByid.class);
                startActivity(intent);
                break;
            case R.id.b3:
                Intent intent1=new Intent(Menumanage.this,AddInfo.class);
                startActivity(intent1);
                break;
            case R.id.b4:
                Intent intent2=new Intent(Menumanage.this,UpdateInfoOne.class);
                startActivity(intent2);
                break;
            case R.id.b5:
                Intent intent3=new Intent(Menumanage.this,DeleteInfo.class);
                startActivity(intent3);
                break;
            case R.id.b6:
                Intent intent4=new Intent(Menumanage.this,Backstage.class);
                startActivity(intent4);
                break;
        }
    }





}
