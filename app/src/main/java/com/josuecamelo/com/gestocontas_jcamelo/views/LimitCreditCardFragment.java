package com.josuecamelo.com.gestocontas_jcamelo.views;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.josuecamelo.com.gestocontas_jcamelo.R;
import com.josuecamelo.com.gestocontas_jcamelo.controllers.CreditCardController;
import com.josuecamelo.com.gestocontas_jcamelo.models.CreditCard;

/**
 * A simple {@link Fragment} subclass.
 */
public class LimitCreditCardFragment extends Fragment {


    public LimitCreditCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_limit_credit_card, container, false);

        TextView currentLimitTXT = view.findViewById(R.id.currentLimitTXT);

        CreditCard cc = CreditCardController.get();

        if(cc != null){
            currentLimitTXT.setText(String.format("%.2f", cc.getCurrentLimit()) +" "+getString(R.string.coin));
        }else{
            currentLimitTXT.setText(String.format("%.2f",0.0) + " "+getString(R.string.coin));
        }

        return view;
    }

}
