package com.boxsand.udaybhasker.sandbox;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    private Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        final ImageView iV1=(ImageView)findViewById(R.id.iV1);
        final ImageView iV2=(ImageView)findViewById(R.id.iV2);
        final Animation an= AnimationUtils.loadAnimation(getBaseContext(),R.anim.splashroate);
        final Animation an1= AnimationUtils.loadAnimation(getBaseContext(),R.anim.splashstay);
        final Animation an2= AnimationUtils.loadAnimation(getBaseContext(),R.anim.fade);



        iV1.startAnimation(an);
       // iV1.startAnimation(an1);

        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {




                iV1.setVisibility(View.GONE);
                iV2.setVisibility(View.VISIBLE);
                iV2.startAnimation(an1);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        an1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {


                iV2.startAnimation(an2);
              //  iV2.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        an2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {


                iV2.setVisibility(View.GONE);
                // sleep();
                finish();
                Intent i=new Intent(getBaseContext(),InstruStart.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });




    }
}
