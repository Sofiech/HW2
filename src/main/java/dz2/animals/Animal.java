package dz2.animals;

/**
 * FileName: Animals
 * Author: aspid
 * Date: 13.08.2022 18:13
 * Description:
 */
public abstract class Animal {              //запрет на создание абстрактного класса Animal  с помощью final!!
                                        //созданы имя,цвет, возраст, вес
    protected static String name;
    protected static int age;
    protected static int weight;
    protected static String color;

    public Animal(String name, int age, int weight, String color) {
        Animal.name = name;                     //this.name = name;
        Animal.age =  age;
        Animal.weight = weight;
        Animal.color = color;
    }

    public Animal() {

    }

    //прописываем условие по года/года/лет в соотвествии с условем задачи до 100 лет))
    public String getOld()
    {
        String old = " ";
        boolean lastAge = (age % 100 >= 11) && (age % 100 <=14);
        if (age == 1) old = "год";
        else if (age == 0 || age >=5 && age <=9) old = "лет";
        else if (age >= 2 && age <= 4) old = "года";
        else old = "лет";
        return old;
    }
                                    //созданы методы ем, пью, иду, говорю
    public void eat() {
        System.out.println("I am eating");
    }

    public void drink() {
        System.out.println("I am drinking");
    }

    public void go() {
        System.out.println("I am going");
    }

    public void say() { System.out.println("I am saying");
        return;
    }

        //созданы методы Gettery&Settery
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }



    public void setName(String name) {
        Animal.name = name;
    }

    public void setAge(int age) {
        Animal.age = age;
    }

    public void setWeight(int weight) {
        Animal.weight = weight;
    }

    public void setColor(String color) {
        Animal.color = color;
    }

                                    //переопределен метод toString
    @Override
    public String toString() {
    return "Hi! my name is " + name + ", my age is - " + age + " " + getOld() + ", " + "my weight is - " + weight +" kg, " + "my color is - " + color;
    }

                //переопределили equels/hash-code для сравнения
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
                                     //переопределили hash-код для сравнения
    @Override
    public int hashCode() {
        return super.hashCode();
    }

}



