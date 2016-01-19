package com.saitej3.medaramjathara.activity;

/**
 * Created by Sai Teja on 1/10/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.saitej3.medaramjathara.R;
import com.saitej3.medaramjathara.adapter.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EmergencyFragment extends Fragment {

    ExpandableListView expListView;
    ExpandableListAdapter listAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private static String[] numbers = null;
    public EmergencyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_emergency, container, false);

        expListView = (ExpandableListView) rootView.findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();
        numbers = getActivity().getResources().getStringArray(R.array.phonenum);

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "7794879899"));
                startActivity(intent);
                return false;
            }
        });

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
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Ambulance");
        listDataHeader.add("Police");
        listDataHeader.add("Blood Bank");
        listDataHeader.add("Officials");

        // Adding child data
        List<String> ambulance = new ArrayList<String>();
        ambulance.add("Ram Hospital");
        ambulance.add("Shyam Hosp");

        List<String> police = new ArrayList<String>();
        police.add("Commisioner");
        police.add("Inspector");
        police.add("ASI");
        police.add("SI");


        List<String> bloodbank = new ArrayList<String>();
        bloodbank.add("1");
        bloodbank.add("2");

        List<String> officials= new ArrayList<String>();
        officials.add("Managment");
        officials.add("Complaint");

        listDataChild.put(listDataHeader.get(0), ambulance); // Header, Child data
        listDataChild.put(listDataHeader.get(1), police);
        listDataChild.put(listDataHeader.get(2), bloodbank);
        listDataChild.put(listDataHeader.get(3), officials);
    }
}


