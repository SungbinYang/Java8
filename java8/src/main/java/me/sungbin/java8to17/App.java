package me.sungbin.java8to17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
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

//        List<String> names = new ArrayList<>();
//        names.add("sungbin");
//        names.add("whiteship");
//        names.add("toby");
//        names.add("foo");

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
        // 직접 성능측정을 해보면서 병럴처릴 할지 안 할지를 결정한다.
//        List<String> collect = names.parallelStream().map(s -> {
//            System.out.println(s + " " + Thread.currentThread().getName());
//            return s.toUpperCase();
//        }).collect(Collectors.toList());
//        collect.forEach(System.out::println);

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpq", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", true));

        List<List<OnlineClass>> sungbinEvents = new ArrayList<>();
        sungbinEvents.add(springClasses);
        sungbinEvents.add(javaClasses);

        System.out.println("spring으로 시작하는 수업");
        List<OnlineClass> spring = springClasses.stream().filter(s -> s.getTitle().startsWith("spring")).collect(Collectors.toList());
        spring.forEach(s -> System.out.println(s.getTitle()));

        System.out.println("close 되지 않은 수업");
//        springClasses.stream().filter(s -> !s.isClosed()).forEach(s -> System.out.println(s.getTitle()));
        springClasses.stream().filter(Predicate.not(OnlineClass::isClosed)).forEach(s -> System.out.println(s.getTitle()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream().map(OnlineClass::getTitle).forEach(System.out::println);

        System.out.println("두 수업 목록에 들어가있는 모든 수업 아이디 출력");
//        sungbinEvents.stream().map(s -> s.stream().map(OnlineClass::getId).collect(Collectors.toList())).forEach(System.out::println);
        sungbinEvents.stream().flatMap(Collection::stream).forEach(s -> System.out.println(s.getId()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개까지만");
        Stream.iterate(10, i -> i + 1).skip(10).limit(10).forEach(System.out::println);

        System.out.println("자바 수업중에 Test가 들어있는 수업이 있는지 확인");
//        javaClasses.stream().filter(s -> s.getTitle().contains("Test")).forEach(s -> System.out.println(s.getTitle()));
        boolean test = javaClasses.stream().anyMatch(s -> s.getTitle().contains("Test"));
        System.out.println(test);

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
        List<String> spring1 = springClasses.stream().map(OnlineClass::getTitle).filter(title -> title.contains("spring")).collect(Collectors.toList());
        spring1.forEach(System.out::println);
    }
}
