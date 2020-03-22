package com.josuecamelo.com.gestocontas_jcamelo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.josuecamelo.com.gestocontas_jcamelo.controllers.BillController;
import com.josuecamelo.com.gestocontas_jcamelo.models.Bill;

import java.util.List;

public class BillsAdapter extends RecyclerView.Adapter<BillHolder>{

    private List<Bill> billList;

    public BillsAdapter(List<Bill> billList) {
        this.billList = billList;
    }

    @Override
    public BillHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_item,parent,false);
        return new BillHolder(view);
    }

    @Override
    public void onBindViewHolder(final BillHolder holder, int position) {
        Bill bill = billList.get(position);
        holder.description.setText(bill.getDescription());
        holder.value.setText(String.format("%.2f",bill.getValue())+" R$");
        holder.date.setText(bill.getDay()+"/"+bill.getMonth()+"/"+bill.getYear());
        holder.billID = bill.getId();
        holder.payBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BillController.setPayed(holder.billID);
                int id = holder.getAdapterPosition();
                billList.remove(id);
                notifyItemRemoved(id);
                notifyItemRangeChanged(id,billList.size());
            }
        });

    }

    @Override
    public int getItemCount() {
        return billList.size();
    }
}
