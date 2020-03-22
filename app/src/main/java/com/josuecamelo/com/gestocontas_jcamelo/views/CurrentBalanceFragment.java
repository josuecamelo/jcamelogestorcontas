package com.josuecamelo.com.gestocontas_jcamelo.views;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.josuecamelo.com.gestocontas_jcamelo.R;
import com.josuecamelo.com.gestocontas_jcamelo.controllers.BankController;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentBalanceFragment extends Fragment {


    public CurrentBalanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current_balance, container, false);

        TextView balanceResultTXT = view.findViewById(R.id.balanceResultTXT);
        balanceResultTXT.setText(String.format("%.2f",BankController.getBalance()) +" "+getString(R.string.coin));

        return  view;
    }

}
