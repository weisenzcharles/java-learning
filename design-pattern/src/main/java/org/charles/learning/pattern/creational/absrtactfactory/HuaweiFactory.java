package org.charles.learning.pattern.creational.absrtactfactory;

public class HuaweiFactory implements IDeviceFactory {
    @Override
    public Mobile produceMobile() {
        return new HuaweiMobile();
    }

    @Override
    public Router produceRouter() {
        return new HuaweiRouter();
    }
}
