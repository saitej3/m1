package com.saitej3.medaramjathara.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.saitej3.medaramjathara.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Rohts on 1/24/2016.
 */
public class Policefragment extends Fragment {
    public Policefragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_police, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.list_crowd);

        String[] values = getResources().getStringArray(R.array.crowd_points);
        List<String> newList = Arrays.asList(values);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(), R.layout.list_item_nav, newList);

        listView.setAdapter(arrayAdapter);

        ListView listView1 = (ListView) rootView.findViewById(R.id.list_pilgrims);

        String[] values1 = getResources().getStringArray(R.array.pilgrims_points);
        List<String> newList1 = Arrays.asList(values1);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(
                getActivity(), R.layout.list_item_nav, newList1);

        listView1.setAdapter(arrayAdapter1);

        // setListViewHeightBasedOnChildren(listView);
        // setListViewHeightBasedOnChildren(listView1);
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

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ArrayAdapter listAdapter = (ArrayAdapter) listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}