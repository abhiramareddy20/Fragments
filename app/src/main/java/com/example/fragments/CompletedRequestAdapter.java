package com.example.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CompletedRequestAdapter extends RecyclerView.Adapter<CompletedRequestAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewForUv";
    //vars
    private ArrayList<String> date = new ArrayList<>();
    private ArrayList<String> location = new ArrayList<>();
    private ArrayList<String> desc = new ArrayList<>();

    private Context mContext;

    public CompletedRequestAdapter(Context context,ArrayList<String> date, ArrayList<String> loc,ArrayList<String> desc) {

        this.mContext = context;
        this.date = date;
        this.location = loc;
        this.desc = desc;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_requests, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");


        holder.date.setText(date.get(position));
        holder.location.setText(location.get(position));
        holder.descreption.setText(desc.get(position));

        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Accepted", Toast.LENGTH_SHORT).show();
                /*Intent i = new Intent(view.getContext(),Todays_date.class);
                view.getContext().startActivity(i);*/
            }
        });

        holder.reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Rejected", Toast.LENGTH_SHORT).show();
                /*Intent i = new Intent(view.getContext(),Payment.class);
                view.getContext().startActivity(i);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return date.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView date,location,descreption;
        Button accept,reject;

        public ViewHolder(View itemView) {
            super(itemView);

            date                 = itemView.findViewById(R.id.date);
            location             = itemView.findViewById(R.id.location);
            descreption          = itemView.findViewById(R.id.descreption);
            accept               = itemView.findViewById(R.id.accept);
            reject          = itemView.findViewById(R.id.reject);
        }
    }


}
