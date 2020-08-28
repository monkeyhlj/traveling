package com.example.administrator.traveling.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.traveling.R;

import java.util.ArrayList;

public class SelectUser extends AppCompatActivity {

    LinearLayout li;
    ArrayList<User> list1;
String s=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);
        li=(LinearLayout)findViewById(R.id.li);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        /*s=bundle.getString("list1");
        TextView t1 = new TextView(SelectUser.this);
        t1.setText(s);
        li.addView(t1);*/
        list1=(ArrayList<User>)bundle.getSerializable("list1");
        for(User i:list1){
            TextView t1 = new TextView(SelectUser.this);
            t1.setText(i.getUsername());
            li.addView(t1);
            TextView t2 = new TextView(SelectUser.this);
            t2.setText(i.getPassword());
            li.addView(t2);
        }


    }
}
