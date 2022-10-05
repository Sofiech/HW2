package dz2.animals.pets;

import dz2.animals.Animal;

/**
 * FileName: Cat
 * Author: aspid
 * Date: 13.08.2022 18:13
 * Description:
 */
public class Cat extends Animal {

    public Cat(String name, int age, int weight, String color)
            {super(name, age, weight, color);}

    public Cat() {
        super();
    }


    public void say () {
            System.out.println("MEOW-MEOW");
            System.out.println();
            return;
        }
    }

