package com.josuecamelo.com.gestocontas_jcamelo;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class InstallmentHolder extends RecyclerView.ViewHolder{


    public TextView description, value, current, max;
    public ProgressBar progress;
    public Button payBTN;
    public String id;
    public int progressValue;

    public InstallmentHolder(View itemView) {
        super(itemView);

        description = itemView.findViewById(R.id.billItemDescription);
        value = itemView.findViewById(R.id.billItemValue);
        progress = itemView.findViewById(R.id.progress);
        current = itemView.findViewById(R.id.currentAmountTXT);
        max = itemView.findViewById(R.id.maxAmountTXT);
        payBTN = itemView.findViewById(R.id.payBTN);
    }
}
