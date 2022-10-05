import dz2.animals.Animal;
import dz2.animals.birds.Duck;
import dz2.animals.pets.Cat;
import dz2.animals.pets.Dog;
import dz2.data.Command;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static dz2.data.Command.valueOf;

/**
 * FileName: MainGenerator
 * Author: aspid
 * Date: 07.09.2022 13:56
 * Description:
 */

public class MainGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                        //иницилизируем создание Scanner
        List<Animal> animalsList = new ArrayList<>();               //создаем коллекцию ArrayList
        while (true) {
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
            Command myChose = valueOf(userCommand);
            switch (myChose) {                                      //отрабатываем loop по выбору команды через switch
                case ADD:
                    Animal animal = null;
                    System.out.println("What animal do you have (dog, duck, cat)? ");
                    String animalType = sc.next().toLowerCase().trim();   //возвращаем строку с помощью метода trim
                    switch (animalType) {
                        case "dog":
                            animal = new Dog();
                            break;
                        case "cat":
                            animal = new Cat();
                            break;
                        case "duck":
                            animal = new Duck();
                            break;
                        default:
                            System.out.println("We do not have this animal. Enter again!");
                    }
             //заменила IF на SWITCH - отрабатываем ввод на консоли каждого животного
                    assert animal != null;                          // animal != null
                    fillAnimal(sc, animal);
                    animal.say();
                    animalsList.add(animal);
                    break;
                case LIST:
                    for (Animal animals : animalsList) {            //после этой команды выведи все, что вводилось на Консоли по выбранному животному
                        System.out.println(animals.toString());
                    }
                    break;

                case EXIT:
                    System.out.println("See you");
                    System.exit(0);
                default:
                    System.out.println("Unknow type command, CORRECT COMMAND - ADD, LIST, EXIT");
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
        while (true) {
            String ageSrt = sc.next();                    //пусть возраст будет с типом данных строка
            boolean isNumber = false;                     //тип данных boolean с названием переменной isNumber - гипотеза что все числа - это false

            try {                                         //пропускаем через исключение по Exception ->NumberFormat
                age = Integer.parseInt(ageSrt);           //внутри try ->parse преобразовывает строку в число (оболочку Integer - непримитивного формата int)
                isNumber = true;                          //тогда число = true
            }
            catch (NumberFormatException ex) {            // в других случаях - "Error!!"
                System.out.println("Error age");
            }

            isNumber &= age > 0;                         //isNumber = isNumber && age > 0; первоначальный вид строки, мы сократили
            if (isNumber) {                              //если число, то выходим из loop while с помощью break
                break;                                   //ЗАПОМНИТЬ!!! && - проверяет часть кода, & - проверяет все!
            }
        }
        animal.setAge(age);                         //вызов settery делаем после loop while


        System.out.println("Enter the weight of the animal");       //ВЕС (по аналогии с возрастом выполняем проверку на String, отрицательное число
        while (true) {
            String weightStr = sc.next();
            boolean isNumber =false;
            try {
                weight = Integer.parseInt(weightStr);
                isNumber = true;
            }
            catch (NumberFormatException ex) {
                System.out.println("Error weight");
            }
            isNumber &= weight > 0;
           if (isNumber){
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


