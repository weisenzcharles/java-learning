package org.charles.learning.pattern.creational.builder.computer;

public class Director {

    public Computer build(ComputerBuilder computerBuilder) {
        computerBuilder.setCPU("Intel Core i9 12900K");
        computerBuilder.setRAM("Kingston FURY 16GB DDR4 3200");
        computerBuilder.setMainboard("ASUS ROG STRIX Z690-A GAMING WIFI");
        computerBuilder.setDisplay("DELL U3219Q");
        computerBuilder.setHDD("SAMSUNG NVMe 980 PRO With Heatsink 2TB");
        computerBuilder.setPower("");

        Computer computer = computerBuilder.builderComputer();
        return computer;
    }
}
