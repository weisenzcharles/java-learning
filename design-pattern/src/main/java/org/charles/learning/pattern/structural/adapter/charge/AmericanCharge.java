package org.charles.learning.pattern.structural.adapter.charge;

public class AmericanCharge implements Adapter {
    @Override
    public void chargeByAmerican() {
        System.out.println("美国插座标准！");
    }
}
