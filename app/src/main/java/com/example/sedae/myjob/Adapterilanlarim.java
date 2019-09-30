package com.example.sedae.myjob;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapterilanlarim extends RecyclerView.Adapter<Adapterilanlarim.MyViewHolder>{
    Context context;
    ArrayList<Order> orderArrayList;

    public Adapterilanlarim(Context c, ArrayList<Order> o){
        context = c;
        orderArrayList = o;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.ilanlarim_kart,parent,false));
    }


    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.ilanAdi.setText(orderArrayList.get(position).getIlanadi());
        holder.ilanAciklama.setText(orderArrayList.get(position).getIlanaciklamasi());



    }

    public int getItemCount() {
        return orderArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView ilanAdi, ilanAciklama;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ilanAdi = itemView.findViewById(R.id.cv_ilanAdi);
            ilanAciklama = itemView.findViewById(R.id.cv_ilanAciklama);

        }
    }

}
