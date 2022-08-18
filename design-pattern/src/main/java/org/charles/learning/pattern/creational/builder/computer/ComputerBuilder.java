package org.charles.learning.pattern.creational.builder.computer;

/**
 * 构建者抽象类。
 */
public abstract class ComputerBuilder {

    /**
     * CPU。
     *
     * @param maker
     * @return
     */
    abstract ComputerBuilder setCPU(String maker);

    /**
     * 显示器。
     *
     * @param maker
     * @return
     */
    abstract ComputerBuilder setDisplay(String maker);

    /**
     * 主板。
     *
     * @param maker
     * @return
     */
    abstract ComputerBuilder setMainboard(String maker);

    /**
     * 内存。
     *
     * @param maker
     * @return
     */
    abstract ComputerBuilder setRAM(String maker);

    /**
     * 硬盘。
     *
     * @param maker
     * @return
     */
    abstract ComputerBuilder setHDD(String maker);

    /**
     * 电源。
     *
     * @param maker
     * @return
     */
    abstract ComputerBuilder setPower(String maker);

    /**
     * 生成产品套餐。
     *
     * @return
     */
    abstract Computer builderComputer();

}
