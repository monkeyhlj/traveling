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
import android.widget.TextView;

import com.example.administrator.traveling.R;

import java.util.List;

public class DeleteUser extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    EditText edit;
    TextView t2,t3;
    DBService d = new DBService();
    List<User> list = null;
    User u=null;


    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x00002:
                    Intent intent = new Intent(DeleteUser.this, Usermanage.class);
                    startActivity(intent);
                case 0x00001:
                    if(list != null){
                        for(User u:list){
                            // Log.i(TAG, "handleMessage: "+u.toString());
                            t2.setText(u.getUsername());
                            t3.setText(u.getPassword());
                        }
                    }


            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);
        btn1 = (Button) findViewById(R.id.b1);
        btn2 = (Button) findViewById(R.id.b2);
        edit = (EditText) findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
    }

    public void queryuser(View view){
        switch (view.getId())
        {
            case R.id.b1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String name=edit.getText().toString();
                        list=d.queryuser(name);
                        u=list.get(0);
                        Message message = new Message();
                        message.what = 0x00001;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
        }
    }

    public void deleteuser(View view) {
        switch (view.getId()) {
            case R.id.b2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String name = edit.getText().toString();
                        d.deleteuser(name);
                        Message massage = new Message();
                        massage.what = 0x00002;
                        myHandler.sendMessage(massage);
                    }
                }).start();
                break;
        }
    }

}
