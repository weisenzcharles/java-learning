package org.charles.learning.pattern.creational.absrtactfactory;

public class XiaomiFactory implements IDeviceFactory {

    @Override
    public Mobile produceMobile() {
        return new XiaomiMobile();
    }

    @Override
    public Router produceRouter() {
        return new XiaomiRouter();
    }
}
