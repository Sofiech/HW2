package homework2.animals;

public abstract class Animal {                      //запрет на создание абстрактного класса Animal
                                                    //созданы имя,цвет, возраст, вес
    protected String name;
    protected int age;
    protected int weight;
    protected String color;

    public Animal(String name, int age, int weight, String color) {
        this.name = name;                         
        this.age =  age;
        this.weight = weight;
        this.color = color;
    }
    public Animal() {
    }

                                                    //прописываем условие по года/года/лет в соотвествии с условем задачи до 100 лет))
    public String getOld()
    {
        String old = " ";

        int lastAge = age % 100;
        if (lastAge >= 11 && age % 100 <=14) return "лет";
        
        int lastOld = age % 10; 
        if (lastOld == 1) old = "год";
        else if (lastOld == 0 || lastOld >=5 && lastOld <=9) old = "лет";
        else if (lastOld >= 2 && lastOld <= 4) old = "года";
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
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
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
