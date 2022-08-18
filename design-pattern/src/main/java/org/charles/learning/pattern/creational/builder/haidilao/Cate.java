package org.charles.learning.pattern.creational.builder.haidilao;

import org.charles.learning.pattern.creational.builder.mcdonalds.Packing;

/**
 * 美食。
 */
public interface Cate {
    /**
     * 名称。
     *
     * @return
     */
    public String name();

    /**
     * 价格。
     *
     * @return
     */
    public float price();
}
