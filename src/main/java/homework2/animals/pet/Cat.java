package homework2.animals.pet;

import homework2.animals.Animal;

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
