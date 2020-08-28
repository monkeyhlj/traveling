package com.example.administrator.traveling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;



public class CreateView extends AppCompatActivity {
    private static final String TAG = "CreateView" ;
    private LinearLayout ll;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_view);
        ll = findViewById(R.id.ll_view);
        name = findViewById(R.id.name);
    }
    public void fun(View v){
        switch (v.getId()){
            case R.id.add:
                EditText ed = new EditText(this);
                ed.setWidth(200);
                ed.setHeight(140);
                ll.addView(ed);
                break;
            case R.id.search:

                break;
            case R.id.getData:
                int count = ll.getChildCount();
                Log.i(TAG, "fun: "+count);
                Integer index = Integer.parseInt(name.getText().toString());
                Log.i(TAG, "fun: "+index);
                if(index >= count){
                    Toast.makeText(this,"输入错误",Toast.LENGTH_SHORT).show();
                }else{
                    EditText temp = (EditText) ll.getChildAt(index);
                    Toast.makeText(this,"第"+index+"个输入框的数据是"+temp.getText().toString(),Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
