package com.zichenfu.homework3;

public class DataPlan extends Plan implements DataService{

    public DataPlan(){}

    public DataPlan(double amount, double fee) {
        super(amount, fee);
    }

    @Override
    public void show() {
        System.out.println("[上网流量：" + super.getAmount() + "，每月资费： " + super.getFee() + "]");
    }

    @Override
    public void surfing(double data, SimCard simCard) {
        System.out.println(simCard.getUsername() + "有"+data+"GB流量。他正在上网...");
    }
}
