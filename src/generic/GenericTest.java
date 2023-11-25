package generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenericTest {
    public static void main(String... args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        print(Integer.parseInt(br.readLine()));
//        print(Integer.parseInt(br.readLine()));
//        print(Integer.parseInt(br.readLine()));
//        print(br.readLine());
//        print(br.readLine());

        new Print().print(new Cat());
        new Print().print(new Dog());
    }

    public static <T> void print(T something ) {
        System.out.println(something);
    }
}

class Animal {
    private String colour;
    private String type;

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColour() {
        return colour;
    }

    public String getType() {
        return type;
    }

    public void eat() {
        System.out.println("Animal eats...");
    }
}

class Cat extends Animal{
    @Override
    public void eat(){
        System.out.println("Cat eats....");
    }
}


class Dog extends Animal{
    @Override
    public void eat(){
        System.out.println("Dog eats....");
    }
}

class Print <T extends Animal> {
    public void print(T a) {
        a.eat();
        System.out.println("Printing animal...");
    }
}

