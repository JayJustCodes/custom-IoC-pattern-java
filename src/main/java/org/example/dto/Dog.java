package org.example.dto;

public class Dog implements IAnimal {
    @Override
    public void sound() {
        System.out.println("woof");
    }
 }
