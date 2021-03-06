package com.josuecamelo.com.gestocontas_jcamelo.views;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.josuecamelo.com.gestocontas_jcamelo.BillsAdapter;
import com.josuecamelo.com.gestocontas_jcamelo.R;
import com.josuecamelo.com.gestocontas_jcamelo.controllers.BillController;

/**
 * A simple {@link Fragment} subclass.
 */
public class BillListFragment extends Fragment {


    public BillListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bill_list, container, false);

        Button addNew = view.findViewById(R.id.addNewBillBTN);
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new BillFormFragment()).commit();
            }
        });

        RecyclerView billRecycler = view.findViewById(R.id.billsList);
        billRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        BillsAdapter ba = new BillsAdapter(BillController.getAll());
        billRecycler.setAdapter(ba);

        return view;
    }

}
