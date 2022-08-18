package org.charles.learning.pattern.creational.factory.methodfactory;

public class TeslaFactory implements AutoFactory {
    @Override
    public Auto getAuto() {
        return new Tesla();
    }
}
