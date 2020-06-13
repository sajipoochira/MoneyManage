package com.mecherycorp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.TableViewHolder> {

    public List<IncomeData> list;

    public RecyclerAdaptor(List<IncomeData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_table_layout,parent, false);

        TableViewHolder tableViewHolder = new TableViewHolder(view);


        return tableViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TableViewHolder holder, int position) {

        IncomeData data = list.get(position);

        holder.Date.setText(data.getDate());
        holder.Amount.setText(Integer.toString(data.getAmount()));
        holder.Catogery.setText(data.getCategory());
    }

    @Override
    public int getItemCount() {


        return list.size();
    }

    public static class TableViewHolder extends RecyclerView.ViewHolder
    {

        TextView Date,Amount,Catogery;


        public TableViewHolder(@NonNull View itemView) {
            super(itemView);

            Date = itemView.findViewById(R.id.Displaydate);
            Amount = itemView.findViewById(R.id.DisplayAmount);
            Catogery = itemView.findViewById(R.id.DisplayCatogery);


        }
    }


}
