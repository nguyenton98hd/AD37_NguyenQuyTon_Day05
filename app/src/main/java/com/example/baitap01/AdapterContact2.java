package com.example.baitap01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContact2 extends RecyclerView.Adapter<AdapterContact2.Viewhoder> {
    public AdapterContact2(List<Contact> contacts) {
        this.contacts = contacts;
    }

    List<Contact> contacts;
    @NonNull
    @Override
    public AdapterContact2.Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_contact,parent,false);
        AdapterContact2.Viewhoder viewHoder=new AdapterContact2.Viewhoder(view);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterContact2.Viewhoder holder, int position) {
        final Contact contact=contacts.get(position);
        holder.foodname.setText(contact.getFoodname());


    }

    @Override
    public int getItemCount() {
        return contacts.size() ;
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        TextView foodname,money;

        public Viewhoder(@NonNull View itemView) {
            super(itemView);
            foodname=itemView.findViewById(R.id.foodname);
            money=itemView.findViewById(R.id.money);

        }
    }
}
