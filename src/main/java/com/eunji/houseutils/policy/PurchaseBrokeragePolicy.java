package com.eunji.houseutils.policy;

public class PurchaseBrokeragePolicy implements BrokeragePolicy {
    public BrokerageRule createBrokerageRule(Long price) {
        BrokerageRule rule;
        if(price < 50_000_000) {
            rule = new BrokerageRule(0.6, 250_000L);
        } else if (price < 200_000_000) {
            rule = new BrokerageRule(0.5, 800000L);
        } else if  (price < 900_000_000) {
            rule = new BrokerageRule(0.4, null);
        } else if (price < 1200_000_000) {
            rule = new BrokerageRule(0.5, null);
        } else if (price < 1500_000_000){
            rule = new BrokerageRule(0.6, null);
        } else {
            rule = new BrokerageRule(0.7, null);
        }
        return rule;
    }
}
