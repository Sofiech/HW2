package dz2_Animals.all_Animal.pet;

import dz2_Animals.all_Animal.Animal;

public class Cat extends Animal {

    public Cat(String name, int age, int weight, String color)
    {super(name, age, weight, color);}


    public Cat() {
        super();
    }


    public void say () {
        System.out.println("MEOW-MEOW");
        System.out.println();
    }
}