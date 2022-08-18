package org.charles.learning.pattern.creational.builder.computer;

public class Worker extends ComputerBuilder {
    private Computer computer;

    public Worker() {
        this.computer = new Computer();
    }

    @Override
    ComputerBuilder setCPU(String maker) {
        return null;
    }

    @Override
    ComputerBuilder setDisplay(String maker) {
        return null;
    }

    @Override
    ComputerBuilder setMainboard(String maker) {
        return null;
    }

    @Override
    ComputerBuilder setRAM(String maker) {
        return null;
    }

    @Override
    ComputerBuilder setHDD(String maker) {
        return null;
    }

    @Override
    ComputerBuilder setPower(String maker) {
        return null;
    }

    @Override
    Computer builderComputer() {
        return this.computer;
    }
}
