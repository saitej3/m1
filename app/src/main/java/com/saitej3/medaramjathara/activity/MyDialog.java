package com.saitej3.medaramjathara.activity;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.saitej3.medaramjathara.R;


/**
 * Created by Sai Teja on 10/6/2015.
 */
public class MyDialog extends DialogFragment implements View.OnClickListener{
    Button ok;
    EditText tag;
    String ans;
    Communicator communicator;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        communicator= (Communicator) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_dialog,null);
        getDialog().setTitle("Set the Tag .. ");
        tag=(EditText)v.findViewById(R.id.tag);
        ok=(Button)v.findViewById(R.id.ok);
        ok.setOnClickListener(this);




        return v;
    }



    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.ok)
        {
            ans= String.valueOf(tag.getText());
            communicator.onDialogMessage(ans);
            dismiss();
        }

    }


    public interface Communicator
    {
        public void onDialogMessage(String message);
    }




}
