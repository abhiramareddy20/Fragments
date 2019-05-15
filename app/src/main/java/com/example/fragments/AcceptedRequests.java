package com.example.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AcceptedRequests extends Fragment {
View v1;
    private static final String TAG = "NewRequest";
    //vars
    private ArrayList<String> date = new ArrayList<>();
    private ArrayList<String> location = new ArrayList<>();
    private ArrayList<String> desc = new ArrayList<>();
    private ArrayList<String> rid = new ArrayList<>();

    public AcceptedRequests()
    {
        //Empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v1 = inflater.inflate(R.layout.activity_accepted_requests, container, false);


        getcontent();

        return v1;
    }

    private void getcontent() {

        date.add("20/02/2019");
        location.add("Bengaluru");
        desc.add("hello i need a drone service for my sisters wedding. if you can deliver me within a day i can \n " +
                "surely take that. regards abhiram. please see as soon as possible");
        rid.add("12345678");


        date.add("13/03/2019");
        location.add("Mysuru");
        desc.add("lorem epsumsumn hsbvjcb ajbhscjab ajbhcjs jhvdc jhdbc sjhdbhc shdbchj s jdbchhjs shbdcjh hjdbchj shbdcjh");
        rid.add("87654321");

        date.add("01/01/2019");
        location.add("Banglore");
        desc.add("lorem epsumsumn hsbvjcb ajbhscjab ajbhcjs");
        rid.add("09876543");

        date.add("20/02/2019");
        location.add("Bengaluru");
        desc.add("hello i need a drone service for my sisters wedding. if you can deliver me within a day i can \n " +
                "surely take that. regards abhiram. please see as soon as possible");
        rid.add("13579246");

        initRecyclerView();
    }

    private void initRecyclerView() {

        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = v1.findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        AcceptedRequestAdapter adapter = new AcceptedRequestAdapter(getActivity(), date, location,desc,rid);
        recyclerView.setAdapter(adapter);

    }
}
