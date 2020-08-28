package com.example.administrator.traveling.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.traveling.R;

import java.util.ArrayList;

public class Usermanage extends AppCompatActivity {

    Button b1,b2,b3,b4;
    DBService d=new DBService();
    ArrayList<User> list1;
   //String s="jknhk";


    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0x00001:
                    Intent intent=new Intent(Usermanage.this,SelectUser.class);
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
        setContentView(R.layout.activity_usermanage);
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
                        list1=d.selectuser();
                        Message message = new Message();
                        message.what = 0x00001;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
            case R.id.b2:
                Intent intent=new Intent(Usermanage.this,QueryUser.class);
                startActivity(intent);
                break;
            case R.id.b3:
                Intent intent1=new Intent(Usermanage.this,AddUser.class);
                startActivity(intent1);
                break;
            case R.id.b4:
                Intent intent2=new Intent(Usermanage.this,UpdateUser.class);
                startActivity(intent2);
                break;
            case R.id.b5:
                Intent intent3=new Intent(Usermanage.this,DeleteUser.class);
                startActivity(intent3);
                break;
            case R.id.b6:
                Intent intent4=new Intent(Usermanage.this,Backstage.class);
                startActivity(intent4);
                break;
        }
    }

}
