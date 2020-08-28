package com.example.administrator.traveling.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.administrator.traveling.R;
public class Backstage extends AppCompatActivity {

    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backstage);
        /*b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);*/
       // b3.setOnClickListener(new onclick());
    }

    public void fun(View v)
    {
        switch (v.getId()){
            case R.id.b1:
                Intent intent2=new Intent(Backstage.this,Usermanage.class);
                startActivity(intent2);
                break;
            case R.id.b2:
                Intent intent3=new Intent(Backstage.this,Adminmanage.class);
                startActivity(intent3);
                break;
            case R.id.b3:
                Intent intent=new Intent(Backstage.this,Menumanage.class);
                startActivity(intent);
                break;
            case R.id.b4:
                Intent intent1=new Intent(Backstage.this,Userlogin.class);
                startActivity(intent1);
                break;
        }

    }
}

