package org.charles.learning.pattern.structural.bridge.computer;

public class ComputerTest {
    public static void main(String[] args) {

        Desktop apple = new Desktop(new Apple());
        apple.info();

        Laptop dell = new Laptop(new Dell());
        dell.info();

    }
}
