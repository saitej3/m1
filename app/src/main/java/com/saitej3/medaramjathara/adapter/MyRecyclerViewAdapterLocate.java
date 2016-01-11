package com.saitej3.medaramjathara.adapter;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.saitej3.medaramjathara.DataBase.DataBaseHandler;
import com.saitej3.medaramjathara.R;
import com.saitej3.medaramjathara.model.DataObject;
import com.saitej3.medaramjathara.model.Location;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Sai Teja on 1/11/2016.
 */
public class MyRecyclerViewAdapterLocate extends RecyclerView
        .Adapter<MyRecyclerViewAdapterLocate.DataObjectHolder>
{
    private static String LOG_TAG = "MyRecyclerViewAdapterLocate";
    private ArrayList<Location> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        TextView locationName;

        public DataObjectHolder(View itemView) {
            super(itemView);
            locationName = (TextView) itemView.findViewById(R.id.textView);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            final Context context;
            context=v.getContext();
            DataBaseHandler db=new DataBaseHandler(context);
            Log.d("Tag","Clicked");
            int pos=getAdapterPosition();
            Location l= db.getLocation(pos+1);
            String path="http://maps.google.com/maps?f=d&daddr="+l.getLat()+","+l.getLon();

            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse(path));
            context.startActivity(intent);


        }

    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        MyRecyclerViewAdapterLocate.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapterLocate(ArrayList<Location> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_location, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.locationName.setText(mDataset.get(position).getName());
    }

    public static MyClickListener getMyClickListener() {
        return myClickListener;
    }

    public void addItem(Location dataObj, int index) {
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