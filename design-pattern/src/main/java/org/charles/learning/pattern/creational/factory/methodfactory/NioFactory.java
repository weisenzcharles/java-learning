package org.charles.learning.pattern.creational.factory.methodfactory;

public class NioFactory implements AutoFactory {
    @Override
    public Auto getAuto() {
        return new Nio();
    }
}
