package org.charles.learning.pattern.creational.factory.methodfactory;

public class BYDFactory implements AutoFactory {
    public Auto getAuto() {
        return new BYD();
    }
}
