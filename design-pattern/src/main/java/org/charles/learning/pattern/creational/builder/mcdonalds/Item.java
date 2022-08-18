package org.charles.learning.pattern.creational.builder.mcdonalds;

/**
 * 项目。
 */
public interface Item {
    public String name();

    public Packing packing();

    public float price();
}