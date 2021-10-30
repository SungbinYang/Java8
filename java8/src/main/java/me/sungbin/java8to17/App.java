package me.sungbin.java8to17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//        System.out.println(newGreeting.get());
//
//        Function<String, Greeting> sungbinGreeting = Greeting::new;
//        Greeting sungbin = sungbinGreeting.apply("sungbin");
//        System.out.println(sungbin.getName());

//        String[] names = {"sungbin", "whiteship", "toby"};
//        Arrays.sort(names, String::compareToIgnoreCase);
//        System.out.println(Arrays.toString(names));

//        GreetingInterface greetingInterface = new DefaultFoo("sungbin");
//        greetingInterface.printName();
//        greetingInterface.printNameUpperCase();
//
//        GreetingInterface.printAnything();

        List<String> names = new ArrayList<>();
        names.add("sungbin");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

//        name.forEach(System.out::println);
//
//        long l = name.stream().map(String::toUpperCase).filter(s -> s.startsWith("S")).count();
//        name.stream().map(String::toUpperCase).filter(s -> s.startsWith("S")).collect(Collectors.toList());
//        System.out.println(l);
//
//        Spliterator<String> spliterator = name.spliterator();
//        Spliterator<String> stringSpliterator = spliterator.trySplit();
//        while (spliterator.tryAdvance(System.out::println));
//        System.out.println("================================");
//        while (stringSpliterator.tryAdvance(System.out::println));
//
//        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
//        name.sort(compareToIgnoreCase.reversed());
//
//        name.removeIf(s -> s.startsWith("s"));
//
//        name.forEach(System.out::println);

        // 중계형 operator는 얼마든지 심지어 안 올수도 있지만 종료형 operator은 무조건 와야한다. 아니면 중계형은 실행이 되질 않는다.
//        List<String> collect = names.stream().map(s -> {
//            System.out.println(s);
//            return s.toUpperCase();
//        }).collect(Collectors.toList());
//        collect.forEach(System.out::println);
//
//        System.out.println("=======================");
//
//        names.forEach(System.out::println);

//        for (String name : names) {
//            if (name.startsWith("s")) {
//                System.out.println(name.toUpperCase());
//            } else {
//                System.out.println(name);
//            }
//        }

        // 병렬처리가 다 좋은것은 아니다. 보통 데이터가 엄청 많을 경우에 사용한다.
        List<String> collect = names.parallelStream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
