package com.saitej3.medaramjathara.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saitej3.medaramjathara.DataBase.DataBaseHandler;
import com.saitej3.medaramjathara.R;
import com.saitej3.medaramjathara.adapter.MyRecyclerViewAdapter;
import com.saitej3.medaramjathara.adapter.MyRecyclerViewAdapterNotify;
import com.saitej3.medaramjathara.model.DataObject;
import com.saitej3.medaramjathara.model.Location;

import java.util.ArrayList;
import java.util.List;


public class NotificationsFragment extends Fragment {

    DataBaseHandler db;
    ArrayList<String> notifications;
    //listview

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public NotificationsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=new DataBaseHandler(getActivity());
        int count=db.getNotificationsCount();


        notifications = new ArrayList<>();
        for(int i=1;i<=count;i++)
        {
            notifications.add(db.getNotification(i));
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notifications, container, false);



        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerViewNotify);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapterNotify(notifications);
        mRecyclerView.setAdapter(mAdapter);
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
