package com.saitej3.medaramjathara.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.saitej3.medaramjathara.R;


import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Rohts on 1/18/2016.
 */
public class LangActivity extends Activity  implements CardView.OnClickListener{

    Locale myLocale;
    CardView cardVieweng,cardViewtel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang);
        SharedPreferences sharedPref = getPreferences(Context.MODE_MULTI_PROCESS);
        if(sharedPref.getInt("value",-1)==1)
        {
            Log.d("string","new activity started");
            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            //LangActivity.this.finish();
        }
        else
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("value",1);
            editor.commit();
        }



        cardVieweng = (CardView)findViewById(R.id.card_view_1);
        cardViewtel = (CardView)findViewById(R.id.card_view_2);

        cardVieweng.setOnClickListener(this);
        cardViewtel.setOnClickListener(this);

    }
    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        LangActivity.this.finish();
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.card_view_1)
        {
            setLocale("en");

        }
        else
        {
            setLocale("te");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
