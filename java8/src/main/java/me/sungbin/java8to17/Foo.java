package me.sungbin.java8to17;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
//        // 익명 내부 클래스
//        int baseNumber = 10;
//
//        RunSomething runSomething = num -> num + baseNumber; // 순수하지 못한 함수형 프로그래밍

        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        UnaryOperator<Integer> plus = (number) -> number + 10;
        System.out.println(plus.apply(1));

        Function<Integer, Integer> multiply2 = (number) -> number * 2;
        System.out.println(multiply2.apply(1));

        System.out.println(plus10.compose(multiply2).apply(3));
        System.out.println(plus10.andThen(multiply2).apply(2));

        Consumer<Integer> printT = System.out::println;
        printT.accept(10);

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        Predicate<String> startsWithSungbin = (str) -> str.startsWith("sungbin");
        Predicate<Integer> isEven = (i) -> i%2 == 0;


    }
}
