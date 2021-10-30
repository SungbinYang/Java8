package me.sungbin.java8to17;

public class DefaultFoo implements GreetingInterface, Bar {

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    // 직접 오버라이드를 해야한다.
    @Override
    public void printNameUpperCase() {
        GreetingInterface.super.printNameUpperCase();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
