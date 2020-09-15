package com.zichenfu.homework3;

public abstract class Plan {
    private double amount;
    private double fee;

    public Plan(){}

    public Plan(double amount, double fee) {
        this.amount = amount;
        this.fee = fee;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public abstract void show();
}
