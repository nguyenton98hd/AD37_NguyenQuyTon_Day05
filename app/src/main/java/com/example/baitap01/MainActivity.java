package com.example.baitap01;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Contact contact;
    RecyclerView recyclerView;
    AdapterContact adapterContact;
    List<Contact> contacts;
    TextView money1, number;
    Button order;
    String fname, fmoney;
   RelativeLayout cart;
    int dem=0;
    int summony=0;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
       actionBar.hide();
       contacts= new  ArrayList<>();

       contacts.add(new Contact("Pizza Panda",2));
         contacts.add(new Contact("KFC Super",1));
        contacts.add(new Contact("Bread Eggs",4));
        contacts.add(new Contact("Coca Cola",4));
        contacts.add(new Contact("Chicken super",5));
        contacts.add(new Contact("Cup cake",10));
        money1=findViewById(R.id.money);
        number=findViewById(R.id.number);
        recyclerView= findViewById(R.id.rvlist);
        order=findViewById(R.id.btnoder);
        cart=findViewById(R.id.rlcart);
        intent=new Intent(getBaseContext(),Main2Activity.class);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getBaseContext(),RecyclerView.VERTICAL,false);

        adapterContact=new AdapterContact(contacts);
        recyclerView.setAdapter(adapterContact);
        recyclerView.setLayoutManager(layoutManager);

        adapterContact.setIsOnclickContact(new IsOnclickContact() {


            @Override
            public void isOnclickFood(String foodname,int money) {
                contact=new Contact(foodname,money);

                fname=foodname;
                fmoney=String.valueOf(money);
                intent.putExtra("fname",fname);
                intent.putExtra("fmoney",fmoney);

                summony+=money;
                money1.setText(String.valueOf(summony));
                intent.putExtra("summoney",summony);
                dem++;
                number.setText(String.valueOf(dem));

            }


        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum=Integer.valueOf((String) number.getText());
                if(sum>0) {
                    Toast.makeText(getBaseContext(), "Bạn đã order thành công", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getBaseContext(), "Bạn chưa chọn thức ăn ", Toast.LENGTH_LONG).show();
                }
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);

            }
        });


    }


}
