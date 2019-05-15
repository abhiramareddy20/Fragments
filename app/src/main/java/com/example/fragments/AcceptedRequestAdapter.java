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


public class AcceptedRequestAdapter extends RecyclerView.Adapter<AcceptedRequestAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewForUv";
    //vars
    private ArrayList<String> date = new ArrayList<>();
    private ArrayList<String> location = new ArrayList<>();
    private ArrayList<String> desc = new ArrayList<>();
    private ArrayList<String> requestId = new ArrayList<>();
    private Context mContext;

    public AcceptedRequestAdapter(Context context,ArrayList<String> date, ArrayList<String> loc,ArrayList<String> desc,ArrayList<String> req) {

        this.mContext = context;
        this.date = date;
        this.location = loc;
        this.desc = desc;
        this.requestId = req;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accepted_requests, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");


        holder.date.setText(date.get(position));
        holder.location.setText(location.get(position));
        holder.descreption.setText(desc.get(position));
        holder.id.setText(requestId.get(position));

        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Please wait", Toast.LENGTH_SHORT).show();
                /*Intent i = new Intent(view.getContext(),Todays_date.class);
                view.getContext().startActivity(i);*/
            }
        });


    }

    @Override
    public int getItemCount() {
        return date.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView date,location,descreption,id;
        Button accept;

        public ViewHolder(View itemView) {
            super(itemView);

            date                 = itemView.findViewById(R.id.date);
            location             = itemView.findViewById(R.id.location);
            descreption          = itemView.findViewById(R.id.descreption);
            accept               = itemView.findViewById(R.id.accept);
            id                   = itemView.findViewById(R.id.Rid);
        }
    }


}
