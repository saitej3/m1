package com.saitej3.medaramjathara.activity;

/**
 * Created by Sai Teja on 1/10/2016.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saitej3.medaramjathara.DataBase.DataBaseHandler;
import com.saitej3.medaramjathara.R;


public class ComingFragment extends Fragment implements CardView.OnClickListener{

    Fragment fragment=null;
    CardView card1,card2,card3,card4,card5;
    public ComingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_coming, container, false);
        card1 = (CardView) rootView.findViewById(R.id.card1);
        card2 = (CardView) rootView.findViewById(R.id.card2);
        card3 = (CardView) rootView.findViewById(R.id.card3);
        card4 = (CardView) rootView.findViewById(R.id.card4);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);

        // Inflate the layout for this fragment
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

    @Override
    public void onClick(View view) {

        int num=0;

        int id=view.getId();
        switch (id)
        {
            case R.id.card1 :   num=1;
                break;
            case R.id.card2 :   num=2;
                break;
            case R.id.card3 :   num=3;
                break;
            case R.id.card4 :   num=4;
                break;
        }
        fragment=new RoutePath();
        Bundle bundle = new Bundle();
        bundle.putInt("num", num);
        bundle.putString("type","coming");
        fragment.setArguments(bundle);
        if (fragment != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();
        }
    }
}


