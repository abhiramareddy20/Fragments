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

public class NewRequests extends Fragment {

    View v1;
    private static final String TAG = "NewRequest";
    //vars
    private ArrayList<String> date = new ArrayList<>();
    private ArrayList<String> location = new ArrayList<>();
    private ArrayList<String> desc = new ArrayList<>();

    public NewRequests()
    {
        //Empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v1 =  inflater.inflate(R.layout.activity_new_requests, container, false);

        getcontent();

        return v1;
    }

    private void getcontent() {

        date.add("20/02/2019");
        location.add("Bengaluru");
        desc.add("hello i need a drone service for my sisters wedding. if you can deliver me within a day i can \n " +
                "surely take that. regards abhiram. please see as soon as possible");

        date.add("13/03/2019");
        location.add("Mysuru");
        desc.add("lorem epsumsumn hsbvjcb ajbhscjab ajbhcjs jhvdc jhdbc sjhdbhc shdbchj s jdbchhjs shbdcjh hjdbchj shbdcjh");

        date.add("01/01/2019");
        location.add("Banglore");
        desc.add("lorem epsumsumn hsbvjcb ajbhscjab ajbhcjs");

        date.add("20/02/2019");
        location.add("Bengaluru");
        desc.add("hello i need a drone service for my sisters wedding. if you can deliver me within a day i can \n " +
                "surely take that. regards abhiram. please see as soon as possible");


        initRecyclerView();
    }

    private void initRecyclerView() {

        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = v1.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        NewRequestAdapter adapter = new NewRequestAdapter(getActivity(), date, location,desc);
        recyclerView.setAdapter(adapter);

    }
}
