package org.charles.learning.pattern.creational.builder.haidilao;

import java.util.ArrayList;
import java.util.List;

public class Combo {
    private List<Cate> cates = new ArrayList<>();

    public void addCate(Cate cate) {
        cates.add(cate);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Cate cate : cates) {
            cost += cate.price();
        }
        return cost;
    }

    public void printReceipt() {
        for (Cate cate : cates) {
            System.out.print("食物 : " + cate.name());
            System.out.println(", 单价 : " + cate.price());
        }
    }
}
