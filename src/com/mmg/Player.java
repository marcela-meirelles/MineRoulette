package com.mmg;

public class Player extends User {
    // Variables
    private float balance;

    // Constructor
    public Player(String username, String password, String fullname, float balance) {
        super(username, password, fullname);
        this.balance = balance;
    }

    // Properties
    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
