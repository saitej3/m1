package com.saitej3.medaramjathara.activity;

/**
 * Created by Rohts on 1/12/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.saitej3.medaramjathara.R;

public class SplashActivity extends Activity {

    /** Called when the activity is first created. */
    Animation animation,animation1,animation2;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fade_in);
        animation2 = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.anticipate_overshoot);
        animation1 = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fade_in);

        animation.reset();
        ImageView god = (ImageView) findViewById(R.id.godphoto);
        god.clearAnimation();
        god.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                animation1.reset();
                TextView text = (TextView) findViewById(R.id.powered);
                text.setVisibility(View.VISIBLE);
                text.clearAnimation();
                text.startAnimation(animation1);

            }
        });


        animation1.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animation2.reset();
                ImageView nitw = (ImageView) findViewById(R.id.nitwlogo);
                nitw.setVisibility(View.VISIBLE);
                nitw.clearAnimation();
                nitw.startAnimation(animation2);
                ImageView wlpd = (ImageView) findViewById(R.id.wl_pd);
                wlpd.setVisibility(View.VISIBLE);
                wlpd.clearAnimation();
                wlpd.startAnimation(animation2);

            }
        });





        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        /* Duration of wait */
        int SPLASH_DISPLAY_LENGTH = 4000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                Intent mainIntent = new Intent(SplashActivity.this, LangActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();

            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}