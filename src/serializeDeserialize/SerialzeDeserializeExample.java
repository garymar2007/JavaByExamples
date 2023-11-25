package serializeDeserialize;

import java.io.*;

public class SerialzeDeserializeExample {
    public static void main(String... args) {
        try(FileOutputStream fos = new FileOutputStream("person.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            Person p = new Person("Gary", 47);
            oos.writeObject(p);
            System.out.println("Object serialized and saved to person.ser");
        }catch(IOException e){
            e.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream("person.ser");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            Person p = (Person) ois.readObject();
            System.out.println("Object deserialized from person.ser");
            System.out.println("Name: " + p.getName());
            System.out.println("Age: " + p.getAge());
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
