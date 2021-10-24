package me.sungbin.java8to17;

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

        GreetingInterface greetingInterface = new DefaultFoo("sungbin");
        greetingInterface.printName();
        greetingInterface.printNameUpperCase();

        GreetingInterface.printAnything();
    }
}
