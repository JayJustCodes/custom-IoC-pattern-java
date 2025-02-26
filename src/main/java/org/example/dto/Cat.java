package org.example.dto;

public class Cat implements IAnimal {
    @Override
    public void sound() {
        System.out.println("miaow");
    }
}
