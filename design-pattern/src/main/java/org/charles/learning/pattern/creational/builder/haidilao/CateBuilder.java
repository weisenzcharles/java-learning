package org.charles.learning.pattern.creational.builder.haidilao;


import org.charles.learning.pattern.creational.builder.haidilao.dish.Beef;
import org.charles.learning.pattern.creational.builder.haidilao.dish.Mutton;
import org.charles.learning.pattern.creational.builder.haidilao.dish.Vegetables;
import org.charles.learning.pattern.creational.builder.haidilao.drinks.Coke;
import org.charles.learning.pattern.creational.builder.haidilao.drinks.PaleLager;
import org.charles.learning.pattern.creational.builder.haidilao.pot.MushroomHotpot;
import org.charles.learning.pattern.creational.builder.haidilao.pot.SamSunHotpot;
import org.charles.learning.pattern.creational.builder.haidilao.pot.SpicyHotpot;
import org.charles.learning.pattern.creational.builder.haidilao.sauce.SeafoodSauce;
import org.charles.learning.pattern.creational.builder.haidilao.sauce.SesameSauce;
import org.charles.learning.pattern.creational.builder.haidilao.sauce.SpecialSauce;

public class CateBuilder {

    /**
     * 三鲜火锅。
     *
     * @return
     */
    public Combo prepareSamSunHotpot() {
        Combo combo = new Combo();
        combo.addCate(new Vegetables());
        combo.addCate(new SamSunHotpot());
        combo.addCate(new Coke());
        combo.addCate(new SesameSauce());
        combo.addCate(new Beef());
        return combo;
    }

    public Combo prepareSpicyHotpot() {
        Combo combo = new Combo();
        combo.addCate(new SpicyHotpot());
        combo.addCate(new Vegetables());
        combo.addCate(new SpecialSauce());
        combo.addCate(new Mutton());
        combo.addCate(new PaleLager());
        return combo;
    }


    public Combo prepareMushroomHotpot() {
        Combo combo = new Combo();
        combo.addCate(new MushroomHotpot());
        combo.addCate(new Coke());
        combo.addCate(new SeafoodSauce());
        combo.addCate(new Vegetables());
        combo.addCate(new PaleLager());
        combo.addCate(new Beef());
        combo.addCate(new Mutton());
        return combo;
    }
}
