package com.example.administrator.traveling.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.traveling.R;

public class Search extends AppCompatActivity {

   // TextView t1;
    EditText e1;
    String s1=null;
    String lid=null;

    DBService d=new DBService();

    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0x00001:
                   // t1.setText(lid);
                    Bundle bundle=new Bundle();
                    Bundle bundle1=new Bundle();
                    Intent intent=new Intent(Search.this,Usersee.class);
                    bundle.putString("lid",lid);
                    bundle1.putString("s1",s1);
                    intent.putExtras(bundle);
                    intent.putExtras(bundle1);
                    startActivity(intent);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        e1=(EditText)findViewById(R.id.e1);
      //  t1=(TextView)findViewById(R.id.t1);
    }

    public void sousuo(View view){
        switch (view.getId())
        {
            case R.id.b1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        s1=e1.getText().toString();
                        lid=d.selectplace(s1);
                        Message message = new Message();
                        message.what = 0x00001;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
        }
    }



}
