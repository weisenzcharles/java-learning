package org.charles.learning.pattern.creational.builder.haidilao;

public class CateBuilderTest {
    public static void main(String[] args) {
        CateBuilder cateBuilder = new CateBuilder();

        Combo samSunHotpot = cateBuilder.prepareSamSunHotpot();
        System.out.println("三鲜火锅");
        samSunHotpot.printReceipt();
        System.out.println("总价 : " + samSunHotpot.getCost());

        System.out.println("============================================");

        Combo spicyHotpot = cateBuilder.prepareSpicyHotpot();
        System.out.println("麻辣火锅");
        spicyHotpot.printReceipt();
        System.out.println("总价 : " + spicyHotpot.getCost());

        System.out.println("============================================");

        Combo mushroomHotpot = cateBuilder.prepareMushroomHotpot();
        System.out.println("菌菇火锅");
        mushroomHotpot.printReceipt();
        System.out.println("总价 : " + mushroomHotpot.getCost());
    }
}
