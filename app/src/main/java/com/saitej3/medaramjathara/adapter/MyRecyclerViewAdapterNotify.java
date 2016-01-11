package com.saitej3.medaramjathara.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saitej3.medaramjathara.R;

import java.util.ArrayList;

/**
 * Created by Sai Teja on 1/11/2016.
 */
public class MyRecyclerViewAdapterNotify extends RecyclerView.Adapter<MyRecyclerViewAdapterNotify.DataObjectHolder> {

    private static String LOG_TAG = "MyRecyclerViewAdapterNotify";
    private ArrayList<String> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView notificationText;

        public DataObjectHolder(View itemView) {
            super(itemView);
            notificationText = (TextView) itemView.findViewById(R.id.textView);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("Tag","Clicked");
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        MyRecyclerViewAdapterNotify.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapterNotify(ArrayList<String> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_notify, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }



    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.notificationText.setText(mDataset.get(position));
    }

    public void addItem(String dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}