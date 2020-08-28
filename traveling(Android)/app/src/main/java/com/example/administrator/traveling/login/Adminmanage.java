package com.example.administrator.traveling.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.traveling.R;

import java.util.ArrayList;

public class Adminmanage extends AppCompatActivity {

    DBService d=new DBService();
    ArrayList<Admin> list1;


    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0x00001:
                    Intent intent=new Intent(Adminmanage.this,SelectAdmin.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("list1",list1);
                    //bundle.putString("list1",s);
                    intent.putExtras(bundle);
                    startActivity(intent);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmanage);
    }

    public void fun(View view){
        switch (view.getId())
        {
            case R.id.b1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        list1=d.selectadmin();
                        Message message = new Message();
                        message.what = 0x00001;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
            case R.id.b2:
                Intent intent=new Intent(Adminmanage.this,QueryAdmin.class);
                startActivity(intent);
                break;
            case R.id.b3:
                Intent intent1=new Intent(Adminmanage.this,AddAdmin.class);
                startActivity(intent1);
                break;
            case R.id.b4:
                Intent intent2=new Intent(Adminmanage.this,UpdateAdmin.class);
                startActivity(intent2);
                break;
            case R.id.b5:
                Intent intent3=new Intent(Adminmanage.this,DeleteAdmin.class);
                startActivity(intent3);
                break;
            case R.id.b6:
                Intent intent4=new Intent(Adminmanage.this,Backstage.class);
                startActivity(intent4);
                break;
        }
    }

}
