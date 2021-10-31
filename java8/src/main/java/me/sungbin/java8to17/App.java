package me.sungbin.java8to17;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) throws InterruptedException {

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

//        List<OnlineClass> springClasses = new ArrayList<>();
//        springClasses.add(new OnlineClass(1, "spring boot", true));
//        springClasses.add(new OnlineClass(2, "spring data jpq", true));
//        springClasses.add(new OnlineClass(3, "spring mvc", false));
//        springClasses.add(new OnlineClass(4, "spring core", false));
//        springClasses.add(new OnlineClass(5, "rest api development", false));
//
//        List<OnlineClass> javaClasses = new ArrayList<>();
//        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
//        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
//        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", true));
//
//        List<List<OnlineClass>> sungbinEvents = new ArrayList<>();
//        sungbinEvents.add(springClasses);
//        sungbinEvents.add(javaClasses);
//
//        System.out.println("spring으로 시작하는 수업");
//        List<OnlineClass> spring = springClasses.stream().filter(s -> s.getTitle().startsWith("spring")).collect(Collectors.toList());
//        spring.forEach(s -> System.out.println(s.getTitle()));
//
//        System.out.println("close 되지 않은 수업");
////        springClasses.stream().filter(s -> !s.isClosed()).forEach(s -> System.out.println(s.getTitle()));
//        springClasses.stream().filter(Predicate.not(OnlineClass::isClosed)).forEach(s -> System.out.println(s.getTitle()));
//
//        System.out.println("수업 이름만 모아서 스트림 만들기");
//        springClasses.stream().map(OnlineClass::getTitle).forEach(System.out::println);
//
//        System.out.println("두 수업 목록에 들어가있는 모든 수업 아이디 출력");
////        sungbinEvents.stream().map(s -> s.stream().map(OnlineClass::getId).collect(Collectors.toList())).forEach(System.out::println);
//        sungbinEvents.stream().flatMap(Collection::stream).forEach(s -> System.out.println(s.getId()));
//
//        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개까지만");
//        Stream.iterate(10, i -> i + 1).skip(10).limit(10).forEach(System.out::println);
//
//        System.out.println("자바 수업중에 Test가 들어있는 수업이 있는지 확인");
////        javaClasses.stream().filter(s -> s.getTitle().contains("Test")).forEach(s -> System.out.println(s.getTitle()));
//        boolean test = javaClasses.stream().anyMatch(s -> s.getTitle().contains("Test"));
//        System.out.println(test);
//
//        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
//        List<String> spring1 = springClasses.stream().map(OnlineClass::getTitle).filter(title -> title.contains("spring")).collect(Collectors.toList());
//        spring1.forEach(System.out::println);

        // 프리미티브 타입은 Optional이 따로 있다. Optional을 사용하면 boxing, unboxing이 일어날 위험이 있기에 성능적 문제를 야기할수 있다.
//        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
//        spring_boot.setProgress(null);

//        Optional<OnlineClass> spring = springClasses.stream().filter(s -> s.getTitle().startsWith("spring")).findFirst();
//        System.out.println(spring.isPresent());
//
//        spring.ifPresent(s -> System.out.println(s.getTitle()));

//        OnlineClass onlineClass = spring.orElseGet(App::createNewClasses);
//        OnlineClass onlineClass = spring.orElseThrow(IllegalArgumentException::new);
//        Optional<OnlineClass> onlineClass = spring.filter(OnlineClass::isClosed);
//        System.out.println(onlineClass.isPresent());
//        System.out.println(onlineClass.getTitle());

//        Optional<Integer> integer = spring.map(OnlineClass::getId);
//        System.out.println(integer.isPresent());

//        Optional<Progress> progress = spring.flatMap(OnlineClass::getProgress);
//
//        Optional<Optional<Progress>> progress1 = spring.map(OnlineClass::getProgress);
//        Optional<Progress> progress2 = progress1.orElse(Optional.empty());

        // 멀티스레드 환경에서 안전하게 사용하기가 쉽지 않다.
//        Date date = new Date();
//        long time = date.getTime();
//        System.out.println(date);
//        System.out.println(time);
//
//        Thread.sleep(1000 * 3);
//        Date after3Seconds = new Date();
//        System.out.println(after3Seconds);
//        after3Seconds.setTime(time);
//        System.out.println(after3Seconds);

//        Calendar sungbinBirthday = new GregorianCalendar(1996, Calendar.MAY, 22);
//        System.out.println(sungbinBirthday.getTime());
//        sungbinBirthday.add(Calendar.DAY_OF_YEAR, 1);
//        System.out.println(sungbinBirthday.getTime());

        Date date = new Date();
        long time = date.getTime();
        System.out.println(time); // 기계용 시간

        
    }

//    private static OnlineClass createNewClasses() {
//        System.out.println("creating new online class");
//        return new OnlineClass(10, "New class", false);
//    }
}
