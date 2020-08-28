package com.example.administrator.traveling.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.traveling.R;

import java.sql.SQLException;

public class AddAdmin extends AppCompatActivity {

    private Button btn2;
    private Button btn1;
    EditText edit1;
    EditText edit2;
    DBService d=new DBService();

    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0x00001:
                    Intent intent=new Intent(AddAdmin.this,Adminmanage.class);
                    startActivity(intent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_admin);
        btn1=(Button)findViewById(R.id.b1);
        // btn1.setOnClickListener(new btn1());
        btn2=(Button)findViewById(R.id.b2);
        // btn2.setOnClickListener(new btn2());
        edit1=(EditText)findViewById(R.id.t1);
        edit2=(EditText)findViewById(R.id.t2);
    }

    public void addadmin (View view){
        switch(view.getId()){
            case R.id.b1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String name=edit1.getText().toString();
                        String password=edit2.getText().toString();

                        d.saveadmin(name,password);

                        Message massage=new Message();
                        massage.what=0x00001;
                        myHandler.sendMessage(massage);
                    }
                }).start();
                break;
        }
    }


}
