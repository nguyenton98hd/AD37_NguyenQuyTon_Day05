package com.example.baitap01;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.ViewHoder> {
    List<Contact> contacts;
    IsOnclickContact isOnclickContact;

    public AdapterContact(List<Contact> contacts) {
        this.contacts=contacts;
    }

    public void setIsOnclickContact(IsOnclickContact isOnclickContact) {
        this.isOnclickContact = isOnclickContact;
    }

    @NonNull
    @Override
    public AdapterContact.ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_contact,parent,false);
        ViewHoder viewHoder=new ViewHoder(view);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
    final Contact contact=contacts.get(position);
    holder.foodname.setText(contact.getFoodname());

    holder.foodname.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            isOnclickContact.isOnclickFood(contact.foodname,contact.money);

        }
    });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView foodname,number,money;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            foodname=itemView.findViewById(R.id.foodname);
            number=itemView.findViewById(R.id.number);
            money=itemView.findViewById(R.id.money);
        }
    }
}
