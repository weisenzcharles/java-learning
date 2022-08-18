package org.charles.learning.pattern.structural.adapter.charge;

public abstract class AbstractAdapter implements Target {
    Adapter adapter;

    public AbstractAdapter(Adapter adapter) {
        this.adapter = adapter;
    }
}
