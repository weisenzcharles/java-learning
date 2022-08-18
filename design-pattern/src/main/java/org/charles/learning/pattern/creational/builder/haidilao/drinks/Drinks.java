package org.charles.learning.pattern.creational.builder.haidilao.drinks;

import org.charles.learning.pattern.creational.builder.haidilao.Cate;

/**
 * 饮品。
 */
public abstract class Drinks implements Cate {
    @Override
    public abstract float price();
}
