package me.sungbin.java8to17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();

        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("sungbin"));

        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("sungbin"));

        Supplier<Greeting> newGreeting = Greeting::new;
        newGreeting.get();

        Function<String, Greeting> sungbinGreeting = Greeting::new;
        System.out.println(sungbinGreeting.apply("sungbin").getName());

        String[] names = {"sungbin", "robert", "toby"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
