package homework2.animals.birds;

import homework2.animals.Animal;

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
