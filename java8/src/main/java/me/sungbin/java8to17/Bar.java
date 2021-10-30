package me.sungbin.java8to17;

public interface Bar {

    default void printNameUpperCase() {
        System.out.println("BAR");
    }
}
