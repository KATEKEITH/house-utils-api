package com.eunji.houseutils.policy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrokeragePolicyTest {
    PurchaseBrokeragePolicy purchaseBrokeragePolicy;
    RentBrokeragePolicy rentBrokeragePolicy;

    @BeforeEach
    public void setup() {
        purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();
        rentBrokeragePolicy = new RentBrokeragePolicy();
    }


    @Test
    public void testPurchaseBrokeragePolicy() {
        Assertions.assertEquals(
                purchaseBrokeragePolicy.calculate(30_000_000L), 180_000L);
        Assertions.assertEquals(
                purchaseBrokeragePolicy.calculate(100_000_000L), 500_000L);
        Assertions.assertEquals(
                purchaseBrokeragePolicy.calculate(500_000_000L), 2_000_000L);
        Assertions.assertEquals(
                purchaseBrokeragePolicy.calculate(800_000_000L), 3_200_000L);
        Assertions.assertEquals(
                purchaseBrokeragePolicy.calculate(1_000_000_000L), 5_000_000L);
    }
}
