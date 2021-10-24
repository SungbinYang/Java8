package me.sungbin.java8to17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
//        Greeting greeting = new Greeting();
//
//        UnaryOperator<String> hi = Greeting::hi;
//        System.out.println(hi.apply("sungbin"));
//
//        UnaryOperator<String> hello = greeting::hello;
//        System.out.println(hello.apply("sungbin"));
//
//        Supplier<Greeting> newGreeting = Greeting::new;
//        newGreeting.get();
//
//        Function<String, Greeting> sungbinGreeting = Greeting::new;
//        System.out.println(sungbinGreeting.apply("sungbin").getName());
//
//        String[] names = {"sungbin", "robert", "toby"};
//        Arrays.sort(names, String::compareToIgnoreCase);
//        System.out.println(Arrays.toString(names));

//        GreetingInterface greetingInterface = new DefaultFoo("sungbin");
//        greetingInterface.printName();
//        greetingInterface.printNameUpperCase();
//
//        GreetingInterface.printAnything();

        List<String> name = new ArrayList<>();
        name.add("sungbin");
        name.add("robert");
        name.add("toby");
        name.add("foo");

        name.forEach(System.out::println);

        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> stringSpliterator = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("============================");
        while (stringSpliterator.tryAdvance(System.out::println));

        System.out.println(name.stream().map(String::toUpperCase).filter(s -> s.startsWith("S")).collect(Collectors.toList()));

//        name.removeIf(s -> s.startsWith("s"));
//        name.forEach(System.out::println);

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
    }
}
