package org.example;

public class Main {
    public static void main(String[] args) {
        Application application = new Application();
        application.configure();

        System.out.println(application.getTemperature(0));
    }
}
