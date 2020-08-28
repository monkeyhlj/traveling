package com.example.administrator.traveling.login;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.traveling.R;

import java.util.ArrayList;

public class Usersee extends AppCompatActivity {

    String lid;
    String s1;
    TextView t1;//t2,t3,t4,t5
   // TextView t[];
    Bundle bunde;
    ArrayList<Information> list;
    //ListView lis;
    LinearLayout li;

   // LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    // LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(300, LinearLayout.LayoutParams.WRAP_CONTENT);

    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler(){


        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case 0x00001:
                    for(Information i:list){
//                        for(int j=0;j<list.size();j++)
//                        {
                            TextView t1 = new TextView(Usersee.this);
                            t1.setText(i.getLid());
                            t1.setTextColor(Color.rgb(148,169,0));
                            li.addView(t1);
                        TextView t2 = new TextView(Usersee.this);
                        t2.setText(i.getCname());
                        t2.setTextColor(Color.rgb(148,169,0));
                        li.addView(t2);
                        TextView t3 = new TextView(Usersee.this);
                        t3.setText(i.getPlace());
                        t3.setTextColor(Color.rgb(148,169,0));
                        li.addView(t3);
                        TextView t4 = new TextView(Usersee.this);
                        t4.setText(i.getSpecial());
                        t4.setTextColor(Color.rgb(148,169,0));
                        li.addView(t4);


                            //t.setLayoutParams(layoutParams);

                            // t[j].setText(i.getCname());
                            //t[j].setId(j);
                           // lis.setAdapter(new ArrayAdapter<Information>(this,android.R.layout.activity_list_item,t));
//                        }
                        /*t2.setText(i.getLid());
                        t3.setText(i.getCname());
                        t4.setText(i.getPlace());
                        t5.setText(i.getSpecial());*/
                    }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usersee);
        t1=(TextView)findViewById(R.id.t1);
        li=(LinearLayout)findViewById(R.id.li);
        //lis=(ListView)findViewById(R.id.l1);
       /* t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        t5=(TextView)findViewById(R.id.t5);*/
        bunde = this.getIntent().getExtras();
        lid = bunde.getString("lid");
        s1 = bunde.getString("s1");
        t1.setText(s1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                DBService d=new DBService();
                list= d.selectinfobyid(lid);
                Message message = new Message();
                message.what = 0x00001;
                myHandler.sendMessage(message);
            }
        }).start();



    }

}
