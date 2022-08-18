package org.charles.learning.pattern.structural.adapter.charge;

public class ChargeTest {
    public static void main(String[] args) {
        Adapter adapter = new AmericanCharge();
        AbstractAdapter abstractAdapter = new ChinaAdapter(adapter);
        abstractAdapter.chargeByChina();
    }
}
