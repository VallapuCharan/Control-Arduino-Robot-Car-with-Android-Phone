package com.boxsand.udaybhasker.sandbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.view.View;
import android.widget.Toast;


public class InstruStart extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuinstrstart);
        ImageView instruct=(ImageView)findViewById(R.id.imgv1_ins_menu);
        ImageView startapp=(ImageView)findViewById(R.id.imgv1_start_menu);

    }

        public void start(View v){
        Intent istartapp=new Intent(getBaseContext(),MainActivity.class);
        startActivity(istartapp);
    }


    }

