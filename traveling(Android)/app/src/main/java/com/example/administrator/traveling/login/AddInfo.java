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
import android.widget.EditText;

import com.example.administrator.traveling.R;

public class AddInfo extends AppCompatActivity {

    EditText e1,e2,e3,e4;
    Button b1;
    String s1,s2,s3,s4;
    DBService d=new DBService();

    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0x00001:
                    Intent intent=new Intent(AddInfo.this,Menumanage.class);
                    startActivity(intent);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        b1=(Button)findViewById(R.id.b1);
    }

    public void add(View view){
        switch (view.getId())
        {
            case R.id.b1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        s1=e1.getText().toString();
                        s2=e2.getText().toString();
                        s3=e3.getText().toString();
                        s4=e4.getText().toString();
                        d.addinfo(s1,s2,s3,s4);
                        Message message = new Message();
                        message.what = 0x00001;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
        }
    }


}
