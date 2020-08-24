package com.zichenfu.homework3;

public class SimCard {
    private String type;
    private String number;
    private String username;
    private String password;
    private double balance;
    private double talkLimit;
    private double dataLimit;

    public SimCard(){}

    public SimCard(String type, String number, String username, String password, double balance, double talkLimit, double dataLimit) {
        this.type = type;
        this.number = number;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.talkLimit = talkLimit;
        this.dataLimit = dataLimit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTalkLimit() {
        return talkLimit;
    }

    public void setTalkLimit(double talkLimit) {
        this.talkLimit = talkLimit;
    }

    public double getDataLimit() {
        return dataLimit;
    }

    public void setDataLimit(double dataLimit) {
        this.dataLimit = dataLimit;
    }

    public void show(){
        System.out.println("[用户名：" + this.username + "，卡号：" + this.number + "，当前余额：" + this.balance + "]");
    }
}
