package org.gary.designpattern.singleton;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

public class MySingleton implements Serializable, Closeable {
    private static MySingleton instance;

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        if (instance == null) {
            synchronized (MySingleton.class) {
                if (instance == null) {
                    instance = new MySingleton();
                }
            }
        }

        return instance;
    }

    public void showmessage() {
        System.out.println("Singleton instance: " + this.toString());
    }

    @Override
    public void close() throws IOException {

    }
}
