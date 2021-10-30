package me.sungbin.java8to17;

@FunctionalInterface
public interface RunSomething {

    int doIt(int number);

    static void printName() {
        System.out.println("sungbin");
    }

    default void printAge() {
        System.out.println("26");
    }
}
