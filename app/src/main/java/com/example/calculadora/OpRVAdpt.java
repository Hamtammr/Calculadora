package com.example.calculadora;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OpRVAdpt extends RecyclerView.Adapter<OpRVAdpt.ViewHolder> {

    // variable for our array list and context
    private ArrayList<OpModal> opModalArrayList;
    private Context context;

    // constructor
    public OpRVAdpt(ArrayList<OpModal> opModalArrayList, Context context) {
        this.opModalArrayList = opModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.op_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OpModal modal = opModalArrayList.get(position);
        holder.operaTV.setText(modal.getOpTxt());
        holder.resulTV.setText(modal.getResultTxt());
    }

    @Override
    public int getItemCount() {
        return opModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView operaTV, resulTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            operaTV = itemView.findViewById(R.id.opTV);
            resulTV = itemView.findViewById(R.id.resultTV);
        }
    }
}