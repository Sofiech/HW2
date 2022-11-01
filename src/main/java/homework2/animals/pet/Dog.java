package homework2.animals.pet;

import homework2.animals.Animal;

public class Dog extends Animal {

    public Dog(String name, int age, int weight, String color)
    {super(name, age, weight, color);}


    public Dog() {
        super();
    }


    public void say() {
        System.out.print("GAVVV ");
        System.out.println();
    }
}
