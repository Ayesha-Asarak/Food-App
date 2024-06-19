package com.example.anoj.Activity.Domain;

import java.util.ArrayList;
import java.util.List;

public class Cart extends ArrayList<Cart> {
    List<Foods> cartList = new ArrayList<>();
    String userAccount = "";

    public Cart() {
    }

    public Cart(List<Foods> cartList, String userAccount) {
        this.cartList = cartList;
        this.userAccount = userAccount;
    }

    public List<Foods> getCartList() {
        return cartList;
    }

    public void setCartList(List<Foods> cartList) {
        this.cartList = cartList;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}
