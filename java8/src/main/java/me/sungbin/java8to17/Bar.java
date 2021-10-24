package me.sungbin.java8to17;

public interface Bar {

//    void printNameUpperCase();

    default void printNameUpperCase() {
        System.out.println("BAR");
    }
}
