package homework2;

import homework2.animals.Animal;
import homework2.animals.birds.Duck;
import homework2.animals.pet.Cat;
import homework2.animals.pet.Dog;
import homework2.data.Command;
import homework2.data.CommandAnimalType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainGeneration {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);                        //иницилизируем создание Scanner
        List<Animal> animalsList = new ArrayList<>();


        while ( true ) {
            System.out.println("Enter the command -> ADD, LIST, EXIT: ");
            String userCommand = sc.next().toUpperCase();

            boolean isCommandValid = false;                         //исключение по неправильному вводу команды
            for (Command command : Command.values()) {
                if (command.name().equals(userCommand)) {
                    isCommandValid = true;
                    break;
                }
            }
                if (!isCommandValid) {
                    System.out.println("Invalid command");
                    continue;
                }

            Command myChose = Command.valueOf(userCommand);


                switch (myChose) {                                      //отрабатываем loop по выбору команды ADD, LIST, EXIT через switch
                case ADD:
                    Animal animal = null;

                    while ( true ) {
                        System.out.println("What animal do you have (DOG, DUCK, CAT)? ");
                        String animalType = sc.next().toUpperCase().trim();

                        boolean isCommandAnimalTypeValid = false;
                        for (CommandAnimalType commandAnimalType : CommandAnimalType.values()) {

                            if (animalType.equals(commandAnimalType.name())) {
                                isCommandAnimalTypeValid = true;
                                break;
                            }
                        }
                        if (!isCommandAnimalTypeValid) {
                            System.out.println("We do not have this animal!");
                            continue;
                        }

                    CommandAnimalType myAnimal = CommandAnimalType.valueOf(animalType);

                    switch (myAnimal) {
                        case CAT:
                                animal = new Cat();
                                break;
                        case DOG:
                                animal = new Dog();
                                break;
                        case DUCK:
                                animal = new Duck();
                                break;
                        default:
                                System.out.println("Again!");
                                break;
                        }

                    if (animal != null) {
                        fillAnimal(sc, animal);
                        animal.say();
                        animalsList.add(animal);
                    }
                    break;
            }


            case LIST:
                    for (Animal animals : animalsList) {            //после этой команды выведи все, что вводилось на Консоли по выбранному животному
                        System.out.println(animals.toString());
                    }
                    break;


            case EXIT:
                    System.out.println("See you");
                    System.exit(0);


            default:
                    System.out.println("Unknow type command, correct command - ADD, LIST, EXIT");
                    throw new IllegalStateException("Unexpected value: " + myChose);
            }
        }
    }

    private static void fillAnimal(Scanner sc, Animal animal) { //создание метода fillAnimal
        String name;
        int age = 0;
        int weight = 0;
        String color;

        System.out.println("Enter the name of the animal");     //ИМЯ
        if (!sc.hasNext()) {
            System.out.println("Enter a world!");
            sc.next();
        }

        name = sc.next();
        animal.setName(name);


        System.out.println("Enter the age of the animal");      //ВОЗРАСТ
        while ( true ) {
            String ageSrt = sc.next();                    //пусть возраст будет с типом данных строка

            boolean isNumber = false;                     //тип данных boolean с названием переменной isNumber - гипотеза что все числа - это false
            try {                                         //пропускаем через исключение по Exception ->NumberFormat
                age = Integer.parseInt(ageSrt);           //внутри try ->parse преобразовывает строку в число (оболочку Integer - непримитивного формата int)
                isNumber = true;                          //тогда число = true
            } catch (NumberFormatException ex) {          // в других случаях - "Error!!"
                System.out.println("Error age");
            }                                            //проверка на значение <1
            isNumber &= age > 0;                         //isNumber = isNumber && age > 0; первоначальный вид строки, мы сократили

            if (isNumber) {                              //если число, то выходим из loop while с помощью break
                break;                                   //ЗАПОМНИТЬ!!! && - проверяет часть кода, & - проверяет все!
            }
        }

        animal.setAge(age);                             //вызов settery делаем после loop while


        System.out.println("Enter the weight of the animal");       //ВЕС (по аналогии с возрастом выполняем проверку на String, отрицательное число


        while ( true ) {
            String weightStr = sc.next();

            boolean isNumber = false;
            try {
                weight = Integer.parseInt(weightStr);
                isNumber = true;
            } catch (NumberFormatException ex) {
                System.out.println("Error weight");
            }
            isNumber &= weight > 0;

            if (isNumber) {
                break;
            }
        }
        animal.setWeight(weight);


        System.out.println("Enter the color of the animal");     //ЦВЕТ

        if (!sc.hasNext()) {
            System.out.println("Enter a world!");
            sc.next();
        }
        color = sc.next();
        animal.setColor(color);
    }
}
