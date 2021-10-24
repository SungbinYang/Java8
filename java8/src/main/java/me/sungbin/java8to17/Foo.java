package me.sungbin.java8to17;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
//        // 익명 내부 클래스
//        int baseNumber = 10;
//
//        RunSomething runSomething = num -> num + baseNumber; // 순수하지 못한 함수형 프로그래밍

//        Plus10 plus10 = new Plus10();
//        System.out.println(plus10.apply(1));
//
//        UnaryOperator<Integer> plus = (number) -> number + 10;
//        System.out.println(plus.apply(1));
//
//        Function<Integer, Integer> multiply2 = (number) -> number * 2;
//        System.out.println(multiply2.apply(1));
//
//        System.out.println(plus10.compose(multiply2).apply(3));
//        System.out.println(plus10.andThen(multiply2).apply(2));
//
//        Consumer<Integer> printT = System.out::println;
//        printT.accept(10);
//
//        Supplier<Integer> get10 = () -> 10;
//        System.out.println(get10.get());
//
//        Predicate<String> startsWithSungbin = (str) -> str.startsWith("sungbin");
//        Predicate<Integer> isEven = (i) -> i%2 == 0;

        Foo foo = new Foo();
        foo.run();

        Supplier<Integer> get10 = () -> 10;

        BinaryOperator<Integer> sum = Integer::sum;

        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        UnaryOperator<Integer> multiply2 = (i) -> i * 2;

        System.out.println(plus10.andThen(multiply2).apply(2));


    }

    private void run() {

        // final 생략 가능 :: 사실상 final인 경우

        int baseNumber = 10;

        // 로컬 클래스 :: 쉐도잉 기능
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;

                System.out.println(baseNumber);
            }
        }

        // 익명 클래스 :: 쉐도잉 가능
        Consumer<Integer> integerConsumer = new Consumer<>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };

        // 람다 :: 쉥도잉 불가능 :: 람다를 감싸는 놈과 같은 스콥이다.
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
    }
}
