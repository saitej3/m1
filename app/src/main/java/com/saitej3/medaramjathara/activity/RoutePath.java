package com.saitej3.medaramjathara.activity;

/**
 * Created by Sai Teja on 1/15/2016.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saitej3.medaramjathara.DataBase.DataBaseHandler;
import com.saitej3.medaramjathara.R;
import com.saitej3.medaramjathara.adapter.MyRecyclerViewAdapterRoute;
import com.saitej3.medaramjathara.model.Location;
import com.saitej3.medaramjathara.model.RouteObject;

import java.util.ArrayList;
import java.util.Arrays;


public class RoutePath extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<String>waypoints;
    public RoutePath() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        int myInt = bundle.getInt("num", -1);
        String type=bundle.getString("type","");

        if(type.contentEquals("going"))
        {
            switch (myInt)
            {
                case 1:  waypoints=new ArrayList<>(Arrays.asList("Your Location","Tadvai","Medaram Jathara"));
                            break;
                case 2:  waypoints=new ArrayList<>(Arrays.asList("Your Location","Tadvai","Medaram Jathara"));
                    break;
                case 3:  waypoints=new ArrayList<>(Arrays.asList("Your Location","Tadvai","Medaram Jathara"));
                    break;
                case 4:  waypoints=new ArrayList<>(Arrays.asList("Your Location","Tadvai","Medaram Jathara"));
                    break;
            }
        }

        else
        {
            switch (myInt)
            {
                case 1: waypoints=new ArrayList<>(Arrays.asList("Your Location","Medaram Jathara"));
                    break;
                case 2:waypoints=new ArrayList<>(Arrays.asList("Your Location","Medaram Jathara"));
                    break;
                case 3:waypoints=new ArrayList<>(Arrays.asList("Your Location","Medaram Jathara"));
                    break;
                case 4:waypoints=new ArrayList<>(Arrays.asList("Your Location","Medaram Jathara"));
                    break;
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_routepath, container, false);
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerViewRoutePath);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapterRoute(getDataSet(waypoints));
        mRecyclerView.setAdapter(mAdapter);

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

    private ArrayList<RouteObject> getDataSet(ArrayList<String> waypoints) {

        DataBaseHandler db=new DataBaseHandler(getActivity());
        ArrayList results = new ArrayList<RouteObject>();

        for(int i=0;i<waypoints.size()-1;i++)
        {
            Location start,end;
            start=db.getLocationByName(waypoints.get(i));
            end=db.getLocationByName(waypoints.get(i+1));
            RouteObject r=new RouteObject(start,end);
            results.add(r);
        }
        return results;
    }
}

