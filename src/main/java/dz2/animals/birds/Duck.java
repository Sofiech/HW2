package dz2.animals.birds;

import dz2.animals.Animal;

/**
 * FileName: Duck
 * Author: aspid
 * Date: 13.08.2022 18:14
 * Description:
 */
public class Duck extends Animal implements Flying {

    public Duck(String name, int age, int weight, String color)
            {super(name, age, weight, color);}

    public Duck() {
        super();
    }

    public void say(){
        System.out.print("KRYA-KRYA ");
        System.out.println();
        return;
    }

    public void fly() {
        System.out.println("I am flying!");
        System.out.println();}

}

