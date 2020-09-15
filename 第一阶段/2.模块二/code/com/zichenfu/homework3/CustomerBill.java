package com.zichenfu.homework3;

public class CustomerBill {
    private double usedTalkLimit;
    private double usedDataLimit;
    private double payment;

    public CustomerBill(){}

    public CustomerBill(double usedTalkLimit, double usedDataLimit, double payment) {
        this.usedTalkLimit = usedTalkLimit;
        this.usedDataLimit = usedDataLimit;
        this.payment = payment;
    }

    public double getUsedTalkLimit() {
        return usedTalkLimit;
    }

    public void setUsedTalkLimit(double usedTalkLimit) {
        this.usedTalkLimit = usedTalkLimit;
    }

    public double getUsedDataLimit() {
        return usedDataLimit;
    }

    public void setUsedDataLimit(double usedDataLimit) {
        this.usedDataLimit = usedDataLimit;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
}
