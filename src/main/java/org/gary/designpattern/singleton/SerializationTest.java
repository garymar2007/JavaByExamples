package org.gary.designpattern.singleton;

import java.io.*;

public class SerializationTest {
    public static void main(String... args) throws IOException, ClassNotFoundException {
        Singleton instance1 = Singleton.INSTANCE;

        // Serialize the instance
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Singleton.ser"))) {
            oos.writeObject(instance1);
        }

        //Deserialize the instance
        Singleton instance2;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Singleton.ser"))) {
            instance2 = (Singleton) ois.readObject();
        }

        // Verify that both instances are the same
        System.out.println("Instance 1 hashcode: " + instance1.hashCode());
        System.out.println("Instance 2 hashcode: " + instance2.hashCode());
        System.out.println("Are both Instances same? " + (instance1 == instance2));
    }
}
