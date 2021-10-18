## 자바 8 소개
- 자바 8
  * LTS 버전
  * 출시일: 2014년 3월
  * 최근 업데이트: [2020년 4월, JDK 8u251](https://www.oracle.com/java/technologies/javase/8u251-relnotes.html)
  * 현재 자바 개발자 중 약 83%가 사용중.
    * [https://www.jetbrains.com/lp/devecosystem-2019/java/](https://www.jetbrains.com/lp/devecosystem-2019/java/)
- LTS(Long-Term-Support)와 비-LTS 버전의 차이
  * 비-LTS는 업데이트 제공 기간이 짧다.
  * 비-LTS 배포 주기 6개월
  * 비-LTS 지원 기간은 배포 이후 6개월
  * LTS 배포 주기 3년 (매 6번째 배포판이 LTS가 된다.)
  * LTS 지원 기간은 5년이상으로 JDK를 제공하는 밴더와 이용하는 서비스에 따라 다르다.
  * 실제 서비스 운영 환경(production)에서는 LTS 버전을 권장한다.
  * [Moving Java Forward Faster-Mark Reinhold](https://mreinhold.org/blog/forward-faster)
  * 다음 LTS: 자바 17
  * 매년 3월과 9월에 새 버전 배포

> “I propose that after Java 9 we adopt a strict, time-based model with a new feature release every six months, update releases every quarter, and a long-term support release every three years.”

- 주요 기능
  * 람다 표현식
  * 메소드 레퍼런스
  * 스트림 API
  * Optional&lt;T&gt;
- JDK 다운로드
  * 오라클 JDK
    * https://www.oracle.com/java/technologies/javase-downloads.html
  * 오픈 JDK
    * 오라클: https://jdk.java.net/14/
    * AdoptOpenJDK: https://adoptopenjdk.net/
    * Amazon Corretto
    * Azul Zulu
- 참고
  * https://www.oracle.com/java/technologies/java-se-support-roadmap.html
  * https://www.javacodegeeks.com/2019/07/long-term-support-mean-openjdk.html
  * https://en.wikipedia.org/wiki/Java_version_history

## 함수형 인터페이스와 람다 표현식 소개
- 함수형 인터페이스 (Functional Interface)
  * 추상 메소드를 딱 하나만 가지고 있는 인터페이스
  * SAM (Single Abstract Method) 인터페이스
  * [@FuncationInterface 애노테이션](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html)을 가지고 있는 인터페이스
- 람다 표현식 (Lambda Expressions)
  * 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
  * 코드를 줄일 수 있다.
  * 메소드 매개변수, 리턴 타입, 변수로 만들어 사용할 수도 있다.
- 자바에서 함수형 프로그래밍
  * 함수를 First class object로 사용할 수 있다.
  * 순수 함수 (Pure function)
    * 사이드 이팩트가 없다. (함수 밖에 있는 값을 변경하지 않는다.)
    * 상태가 없다. (함수 밖에 있는 값을 사용하지 않는다.)
  * 고차 함수 (Higher-Order Function)
    * 함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수도 있다.
  * 불변성

## 자바에서 제공하는 함수형 인터페이스
- Java가 기본으로 제공하는 함수형 인터페이스
  * [java.util.function 패키지](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)
  * 자바에서 미리 정의해둔 자주 사용할만한 함수 인터페이스
  * Function&lt;T, R&gt;
  * BiFunction&lt;T, U, R&gt;
  * Consumer&lt;T&gt;
  * Supplier&lt;T&gt;
  * Predicate&lt;T&gt;
  * UnaryOperator&lt;T&gt;
  * BinaryOperator&lt;T&gt;
- Function<T, R>
  * T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
    * R apply(T t)
  * 함수 조합용 메소드
    * andThen
    * compose
- BiFunction<T, U, R>
  * 두 개의 값(T, U)를 받아서 R 타입을 리턴하는 함수 인터페이스
    * R apply(T t, U u)
- Consumer&lt;T&gt;
  * T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
    * void Accept(T t)
  * 함수 조합용 메소드
    * andThen
- Supplier&lt;T&gt;
  * T 타입의 값을 제공하는 함수 인터페이스
    * T get()
- Predicate&lt;T&gt;
  * T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
    * boolean test(T t)
  * 함수 조합용 메소드
    * And
    * Or
    * Negate
- UnaryOperator&lt;T&gt;
  * Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스
- BinaryOperator&lt;T&gt;
  * BiFunction<T, U, R>의 특수한 형태로, 동일한 타입의 입렵값 두개를 받아 리턴하는 함수 인터페이스
