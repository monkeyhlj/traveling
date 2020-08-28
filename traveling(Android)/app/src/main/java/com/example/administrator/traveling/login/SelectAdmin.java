package com.example.administrator.traveling.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.traveling.R;

import java.util.ArrayList;

public class SelectAdmin extends AppCompatActivity {

    LinearLayout li;
    ArrayList<Admin> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_admin);
        li=(LinearLayout)findViewById(R.id.li);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        list1=(ArrayList<Admin>)bundle.getSerializable("list1");
        for(Admin i:list1){
            TextView t1 = new TextView(SelectAdmin.this);
            t1.setText(i.getUsername());
            li.addView(t1);
            TextView t2 = new TextView(SelectAdmin.this);
            t2.setText(i.getPassword());
            li.addView(t2);
        }
    }
}
