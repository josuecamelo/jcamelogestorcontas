package com.josuecamelo.com.gestocontas_jcamelo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.josuecamelo.com.gestocontas_jcamelo.controllers.InstallmentController;
import com.josuecamelo.com.gestocontas_jcamelo.models.Installment;

import java.util.List;

public class InstallmentAdapter extends RecyclerView.Adapter<InstallmentHolder>{

    private List<Installment> list;

    public InstallmentAdapter(List<Installment> list) {
        this.list = list;
    }

    @Override
    public InstallmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.installment_list,parent,false);
        return new InstallmentHolder(view);
    }

    @Override
    public void onBindViewHolder(final InstallmentHolder holder, int position) {
        Installment element = list.get(position);
        holder.id = element.getId();
        holder.description.setText(element.getDescription());
        holder.value.setText(String.format("%.2f",element.getValue())+" R$");
        holder.current.setText(String.valueOf(element.getCurrentPart()));
        holder.max.setText(String.valueOf(element.getTotalPart()));
        holder.progressValue = element.getCurrentPart();
        holder.progress.setMax(element.getTotalPart());
        holder.progress.setProgress(element.getCurrentPart());
        holder.payBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.progressValue++;
                holder.progress.setProgress(holder.progressValue);
                holder.current.setText(String.valueOf(holder.progressValue));
                if(InstallmentController.incrementInstallment(holder.id)){
                    int id = holder.getAdapterPosition();
                    list.remove(id);
                    notifyItemRemoved(id);
                    notifyItemRangeChanged(id,list.size());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
