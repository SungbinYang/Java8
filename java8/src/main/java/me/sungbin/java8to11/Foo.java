package me.sungbin.java8to11;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        Function<Integer, Integer> plus = (num) -> num + 10;
        System.out.println(plus.apply(1));

        Function<Integer, Integer> multiply2 = (num) -> num * 2;
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2); // 매개변수에 곱하기 먼저 실행 후 더하기
        System.out.println(multiply2AndPlus10.apply(2));

        System.out.println(plus10.andThen(multiply2).apply(2)); // 매개변수에 먼저 더하고 곱하기를 한다.

        Consumer<Integer> printT = System.out::println;
        printT.accept(10);

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        Predicate<String> startsWithSungbin = (s) -> s.startsWith("sungbin");
        System.out.println(startsWithSungbin.test("sungbin2"));


        UnaryOperator<Integer> plus2 = (i) -> i + 2;
        
    }
}
