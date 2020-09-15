package com.zichenfu.homework3;

public class Test {

    public static void main(String[] args){
        SimCard card = new SimCard(
                            SimCardEnum.BIGCARD.getCardType(),
                            "*******9999",
                            "Zichen",
                            "*******",
                            1000.00,
                            900.00,
                            10.00
                        );

        TalkPlan talkPlan = new TalkPlan(card.getTalkLimit(), 100, 50.00);
        DataPlan dataPlan = new DataPlan(card.getDataLimit(), 10.00);
        talkPlan.show();
        dataPlan.show();
        talkPlan.talking(card.getTalkLimit(), card);
        dataPlan.surfing(card.getDataLimit(), card);
    }
}
