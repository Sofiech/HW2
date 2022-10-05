package dz2.animals.pets;

import dz2.animals.Animal;

/**
 * FileName: Dog
 * Author: aspid
 * Date: 13.08.2022 18:13
 * Description:
 */
public class Dog extends Animal {

    public Dog(String name, int age, int weight, String color)
    {super(name, age, weight, color);}

    public Dog() {
        super();
    }


    public void say() {
       System.out.print("GAVVV ");
       System.out.println();
        return;
    }
}


