package org.example;

import org.example.dto.Cat;
import org.example.dto.Dog;
import org.example.dto.IAnimal;

public class App {

    public static void main( String[] args ) {
        IAnimal duck = () -> System.out.println("Kryo");

        duck.sound();

        IAnimal dog = new Dog();
        dog.sound();

        IAnimal cat = new Cat();
        cat.sound();
    }
}
