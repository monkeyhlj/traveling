package com.example.administrator.traveling.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.traveling.R;
public class UserRegist extends AppCompatActivity {

    DBService d=new DBService();
    EditText e1,e2;
    String s1=null;
    String s2=null;

    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //Log.i(TAG, "handleMessage: "+t);
            switch (msg.what){
                case 0x00001:
                    Toast.makeText(getApplicationContext(),"注册成功！",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(UserRegist.this,Userlogin.class);
                    startActivity(intent);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_regist);
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
    }

    public void userreg(View view) {
        switch (view.getId()) {
            case R.id.b1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        s1 = e1.getText().toString();
                        s2 = e2.getText().toString();
                        d.saveuser(s1, s2);
                        Message message = new Message();
                        message.what = 0x0001;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
        }
    }
}
