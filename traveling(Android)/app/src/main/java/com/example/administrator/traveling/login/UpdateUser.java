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

public class UpdateUser extends AppCompatActivity {

    private static final String TAG = "UpdateUser" ;
    EditText e1;
    String s1=null;
    DBService d=new DBService();
    ArrayList<User> list;
    LinearLayout li;
    EditText t2;
    TextView t1;
    String s11,s22;


    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler(){
        @SuppressLint("ResourceType")
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0x00001:
                    for(User i:list){
                        TextView t1 = new TextView(UpdateUser.this);
                        t1.setText(i.getUsername());
                        t1.setWidth(700);
                        li.addView(t1);
                        EditText t2 = new EditText(UpdateUser.this);
                        t2.setText(i.getPassword());
                        //t2.setId(2);
                        li.addView(t2);
                    }
                    break;
                case 0x00002:
                    // e1.setText(s11);
                    Intent intent=new Intent(UpdateUser.this,Usermanage.class);
                    startActivity(intent);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        e1=(EditText)findViewById(R.id.e1);
        li=(LinearLayout)findViewById(R.id.li);
    }

    public void userquery(View view) {
        switch (view.getId()) {
            case R.id.b1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        s1 = e1.getText().toString();
                        list=d.queryuser(s1);
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
                        t1 = (TextView)li.getChildAt(0);
                        s11=t1.getText().toString();
                        t2 = (EditText) li.getChildAt(1);
                        s22=t2.getText().toString();
                        d.updateuser(s11,s22);
                        Message message = new Message();
                        message.what = 0x00002;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
        }
    }

}
