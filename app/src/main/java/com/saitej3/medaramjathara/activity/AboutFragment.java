package com.saitej3.medaramjathara.activity;

/**
 * Created by Sai Teja on 1/10/2016.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saitej3.medaramjathara.DataBase.DataBaseHandler;
import com.saitej3.medaramjathara.R;
import com.saitej3.medaramjathara.model.Location;
import com.saitej3.medaramjathara.model.MarkerItem;


public class AboutFragment extends Fragment {

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataBaseHandler db=new DataBaseHandler(getActivity());
        MarkerItem markerItem=db.getMarker(38);
        Log.d("markeritem",markerItem.getName());
        Log.d("markeritem", String.valueOf(markerItem.getLat()));
        Log.d("markeritem", String.valueOf(markerItem.getLon()));
        Log.d("markeritem", String.valueOf(markerItem.getStatus()));

        db.updateMarker(38, 1);

         markerItem=db.getMarker(38);
        Log.d("markeritem",markerItem.getName());
        Log.d("markeritem", String.valueOf(markerItem.getLat()));
        Log.d("markeritem", String.valueOf(markerItem.getLon()));
        Log.d("markeritem", String.valueOf(markerItem.getStatus()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}


