package com.zichenfu.homework3;

public class TalkPlan extends Plan implements TalkService {

    private int textNumber;

    public TalkPlan() {}

    public TalkPlan(double amount,  int textNumber, double fee) {
        super(amount, fee);
        this.textNumber = textNumber;
    }

    public int getTextNumber() {
        return textNumber;
    }

    public void setTextNumber(int textNumber) {
        this.textNumber = textNumber;
    }

    @Override
    public void show() {
        System.out.println("[通话时长：" + super.getAmount() + "，短信条数：" + this.textNumber + "，每月资费：" + super.getFee() + "]");
    }

    @Override
    public void talking(double talk, SimCard simCard) {
        System.out.println(simCard.getUsername() + "有"+talk+"分钟通话时长。他正在打电话...");
    }
}
