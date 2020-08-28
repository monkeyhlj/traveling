package com.example.administrator.traveling.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.traveling.R;

import java.util.ArrayList;

public class DeleteInfo extends AppCompatActivity {

    EditText e1;
    String s1=null;
    DBService d=new DBService();
    ArrayList<Information> list;
    LinearLayout li;

    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0x00001:
                    for(Information i:list){
                        TextView t1 = new TextView(DeleteInfo.this);
                        t1.setText(i.getLid());
                        //t1.setWidth(700);
                        li.addView(t1);
                        TextView t2 = new TextView(DeleteInfo.this);
                        t2.setText(i.getCname());
                        li.addView(t2);
                        TextView t3 = new TextView(DeleteInfo.this);
                        t3.setText(i.getPlace());
                        li.addView(t3);
                        TextView t4 = new TextView(DeleteInfo.this);
                        t4.setText(i.getSpecial());
                        li.addView(t4);
                    }
                    break;
                case 0x0002:
                    Intent intent=new Intent(DeleteInfo.this,Menumanage.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_info);
        e1=(EditText)findViewById(R.id.e1);
        li=(LinearLayout)findViewById(R.id.li);
    }
    public void infoquery(View view) {
        switch (view.getId()) {
            case R.id.b1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        s1 = e1.getText().toString();
                        list = d.queryinfobyname(s1);
                        Message message = new Message();
                        message.what = 0x00001;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
            case R.id.b2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        d.deleteinfo(s1);
                        Message message = new Message();
                        message.what = 0x00002;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
        }
    }

}
