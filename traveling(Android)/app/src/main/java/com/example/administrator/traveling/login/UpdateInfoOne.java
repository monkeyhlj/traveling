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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.traveling.R;

import java.util.ArrayList;

public class UpdateInfoOne extends AppCompatActivity {

    private static final String TAG = "UpdateInfoOne" ;
    EditText e1;
    String s1=null;
    DBService d=new DBService();
    ArrayList<Information> list;
    LinearLayout li;
    EditText t1,t3,t4;
    TextView t2;
    String s11,s22,s33,s44;

    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler(){
        @SuppressLint("ResourceType")
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0x00001:
                    for(Information i:list){
                        EditText t1 = new EditText(UpdateInfoOne.this);
                        t1.setText(i.getLid());
                        t1.setWidth(700);
                        li.addView(t1);
                        TextView t2 = new TextView(UpdateInfoOne.this);
                        t2.setText(i.getCname());
                        //t2.setId(2);
                        li.addView(t2);
                        EditText t3 = new EditText(UpdateInfoOne.this);
                        t3.setText(i.getPlace());
                        li.addView(t3);
                        EditText t4 = new EditText(UpdateInfoOne.this);
                        t4.setText(i.getSpecial());
                        li.addView(t4);
                        //li.setVisibility();
                      // s22=t3.getText().toString();
                    }
                    break;
                case 0x00002:
                   // e1.setText(s11);
                    Intent intent=new Intent(UpdateInfoOne.this,Menumanage.class);
                    startActivity(intent);
            }
        }
    };


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info_one);
        e1=(EditText)findViewById(R.id.e1);
        li=(LinearLayout)findViewById(R.id.li);
        //t2=(EditText)findViewById(2);
        //s22=t2.getText().toString();
    }

    public void infoquery(View view) {
        switch (view.getId()) {
            case R.id.b1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        s1 = e1.getText().toString();
                        list=d.queryinfobyname(s1);
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
                        int count= li.getChildCount();
                        Log.i(TAG, "fun: "+count);
                        t1 = (EditText)li.getChildAt(0);
                        s11=t1.getText().toString();
                        t2 = (TextView) li.getChildAt(1);
                        s22=t2.getText().toString();
                        t3 = (EditText)li.getChildAt(2);
                        s33=t3.getText().toString();
                        t4 = (EditText)li.getChildAt(3);
                        s44=t4.getText().toString();
                        d.updateinfo(s11,s22,s33,s44);
                        Message message = new Message();
                        message.what = 0x00002;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
        }
    }

}
