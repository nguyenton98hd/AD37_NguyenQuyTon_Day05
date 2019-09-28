package com.example.baitap01;

import java.io.Serializable;

public class Contact implements Serializable {
    String foodname;
    int number;
    int money;
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }



    public Contact(String foodname, int money ) {
        this.foodname = foodname;
        this.money=money;

    }

    public String getFoodname() {
        return foodname;
    }

    public int getNumber() {
        return number;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
