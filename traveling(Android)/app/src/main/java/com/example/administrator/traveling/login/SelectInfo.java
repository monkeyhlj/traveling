package com.example.administrator.traveling.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.traveling.R;

import java.util.ArrayList;
import java.util.List;

public class SelectInfo extends AppCompatActivity {

    //Bundle bunde;
    LinearLayout li;
    ArrayList<Information> list1;
    //TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_info);
        //t1=(TextView)findViewById(R.id.t1);
        li=(LinearLayout)findViewById(R.id.li);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        list1=(ArrayList<Information>)bundle.getSerializable("list1");
        for(Information i:list1){
            TextView t1 = new TextView(SelectInfo.this);
            t1.setText(i.getLid());
            //t1.setTextColor(Color.rgb(148,169,0));
            li.addView(t1);
            TextView t2 = new TextView(SelectInfo.this);
            t2.setText(i.getCname());
            //t2.setTextColor(Color.rgb(148,169,0));
            li.addView(t2);
            TextView t3 = new TextView(SelectInfo.this);
            t3.setText(i.getPlace());
           // t3.setTextColor(Color.rgb(148,169,0));
            li.addView(t3);
            TextView t4 = new TextView(SelectInfo.this);
            t4.setText(i.getSpecial());
            //t4.setTextColor(Color.rgb(148,169,0));
            li.addView(t4);
        }



        }


}
