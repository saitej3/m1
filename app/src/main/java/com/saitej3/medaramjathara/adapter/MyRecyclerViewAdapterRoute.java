package com.saitej3.medaramjathara.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.saitej3.medaramjathara.R;
import com.saitej3.medaramjathara.model.RouteObject;

import java.util.ArrayList;

/**
 * Created by Sai Teja on 1/15/2016.
 */
public class MyRecyclerViewAdapterRoute extends RecyclerView
        .Adapter<MyRecyclerViewAdapterRoute.DataObjectHolder> {

    private static String LOG_TAG = "MyRecyclerViewAdapterRoute";
    private static ArrayList<RouteObject> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView textSource;
        TextView textDestination;
        TextView textno;
        public DataObjectHolder(View itemView) {
            super(itemView);
            textSource = (TextView) itemView.findViewById(R.id.textSource);
            textno= (TextView) itemView.findViewById(R.id.textViewNo);
            textDestination = (TextView) itemView.findViewById(R.id.textDestination);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final Context context;
            context=v.getContext();
            int pos=getAdapterPosition();
            RouteObject r= mDataset.get(pos);
            String path="http://maps.google.com/maps?saddr="+r.getStart().getLat()+","+r.getStart().getLon()+"&daddr="+r.getEnd().getLat()+","+r.getEnd().getLon();
            if(r.getStart().getName().contentEquals("Your Location"))
                 path="http://maps.google.com/maps?f=d&daddr="+r.getEnd().getLat()+","+r.getEnd().getLon();
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse(path));
            context.startActivity(intent);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        MyRecyclerViewAdapterRoute.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapterRoute (ArrayList<RouteObject> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_route_path, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.textno.setText(String.valueOf(position + 1));
        holder.textSource.setText(mDataset.get(position).getStart().getName());
        holder.textDestination.setText(mDataset.get(position).getEnd().getName());
    }

    public void addItem(RouteObject dataObj, int index) {
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