package org.charles.learning.pattern.structural.adapter.charge;

public class ChinaAdapter extends AbstractAdapter {
    public ChinaAdapter(Adapter adapter) {
        super(adapter);
    }

    @Override
    public void chargeByChina() {
        adapter.chargeByAmerican();
        System.out.println("转换成国标！");
    }
}
