package com.example.baitap01;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
 AdapterContact2 adapterContact2;
    RecyclerView recyclerView;
    Contact contact;
    TextView tv;
    String foodname;
    String money;
    List<Contact>contacts;
    AdapterContact2 adapterContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        recyclerView=findViewById(R.id.oder);
        contacts=new ArrayList<>();
        tv=findViewById(R.id.money11);
        Intent intent=getIntent();
        money=intent.getStringExtra("fmoney");
        tv.setText(money);
        foodname=intent.getStringExtra("fname");

        contacts.add(new Contact(foodname,Integer.valueOf(money)));


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getBaseContext(),RecyclerView.VERTICAL,false);
        adapterContact2=new AdapterContact2(contacts);
        recyclerView.setAdapter(adapterContact2);
        recyclerView.setLayoutManager(layoutManager);





    }
}
