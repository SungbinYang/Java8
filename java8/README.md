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

## 람다 표현식
- 람다
  * (인자 리스트) -> {바디}
- 인자 리스트
  * 인자가 없을 때: ()
  * 인자가 한개일 때: (one) 또는 one
  * 인자가 여러개 일 때: (one, two)
  * 인자의 타입은 생략 가능, 컴파일러가 추론(infer)하지만 명시할 수도 있다. (Integer one, Integer two)
- 바디
  * 화상표 오른쪽에 함수 본문을 정의한다.
  * 여러 줄인 경우에 { }를 사용해서 묶는다.
  * 한 줄인 경우에 생략 가능, return도 생략 가능.
- 변수 캡처 (Variable Capture)
  * 로컬 변수 캡처
    * final이거나 effective final 인 경우에만 참조할 수 있다.
    * 그렇지 않을 경우 concurrency 문제가 생길 수 있어서 컴파일가 방지한다.
  * effective final
    * 이것도 역시 자바 8부터 지원하는 기능으로 “사실상" final인 변수. 
    * final 키워드 사용하지 않은 변수를 익명 클래스 구현체 또는 람다에서 참조할 수 있다.
  * 익명 클래스 구현체와 달리 ‘쉐도윙’하지 않는다.
    * 익명 클래스는 새로 스콥을 만들지만, 람다는 람다를 감싸고 있는 스콥과 같다.
- 참고
  * https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#shadowing
  * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

## 메소드 레퍼런스
- 람다가 하는 일이 기존 메소드 또는 생성자를 호출하는 거라면, 메소드 레퍼런스를 사용해서 매우 간결하게 표현할 수 있다.
- 메소드 참조하는 방법

  |제목|내용|
  |------|---|
  |스태틱 메소드 참조|타입::스태틱 메소드|
  |특정 객체의 인스턴스 메소드 참조|객체 레퍼런스::인스턴스 메소드|
  |임의 객체의 인스턴스 메소드 참조|타입::인스턴스 메소드|
  |생성자 참조|타입::new|

  * 메소드 또는 생성자의 매개변수로 람다의 입력값을 받는다.
  * 리턴값 또는 생성한 객체는 람다의 리턴값이다.
- 참고
  * https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
 
## 인터페이스 기본 메소드와 스태틱 메소드
- 기본 메소드 (Default Methods)
  * 인터페이스에 메소드 선언이 아니라 구현체를 제공하는 방법
  * 해당 인터페이스를 구현한 클래스를 깨트리지 않고 새 기능을 추가할 수 있다.
  * 기본 메소드는 구현체가 모르게 추가된 기능으로 그만큼 리스크가 있다.
    * 컴파일 에러는 아니지만 구현체에 따라 런타임 에러가 발생할 수 있다.
    * 반드시 문서화 할 것. (@implSpec 자바독 태그 사용)
  * Object가 제공하는 기능 (equals, hasCode)는 기본 메소드로 제공할 수 없다.
    * 구현체가 재정의해야 한다.
  * 본인이 수정할 수 있는 인터페이스에만 기본 메소드를 제공할 수 있다.
  * 인터페이스를 상속받는 인터페이스에서 다시 추상 메소드로 변경할 수 있다.
  * 인터페이스 구현체가 재정의 할 수도 있다.
- 스태틱 메소드
  * 해당 타입 관련 헬퍼 또는 유틸리티 메소드를 제공할 때 인터페이스에 스태틱 메소드를 제공할 수 있다.
- 참고
  * https://docs.oracle.com/javase/tutorial/java/IandI/nogrow.html
  * https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html

## 자바 8 API의 기본 메소드와 스태틱 메소드
- 자바 8에서 추가한 기본 메소드로 인한 API 변화
- Iterable의 기본 메소드
  * forEach()
  * spliterator()
- Collection의 기본 메소드
  * stream() / parallelStream()
  * removeIf(Predicate)
  * spliterator()
- Comparator의 기본 메소드 및 스태틱 메소드
  * reversed()
  * thenComparing()
  * static reverseOrder() / naturalOrder()
  * static nullsFirst() / nullsLast()
  * static comparing()
- 참고
  * https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html
  * https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html
  * https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html
  * https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html

## Stream 소개
- Stream
  * sequence of elements supporting sequential and parallel aggregate operations
  * 데이터를 담고 있는 저장소 (컬렉션)이 아니다.
  * Funtional in nature, 스트림이 처리하는 데이터 소스를 변경하지 않는다.
  * 스트림으로 처리하는 데이터는 오직 한번만 처리한다.
  * 무제한일 수도 있다. (Short Circuit 메소드를 사용해서 제한할 수 있다.)
  * 중개 오퍼레이션은 근본적으로 lazy 하다.
  * 손쉽게 병렬 처리할 수 있다.
- 스트림 파이프라인
  * 0 또는 다수의 중개 오퍼레이션 (intermediate operation)과 한개의 종료 오퍼레이션 (terminal operation)으로 구성한다.
  * 스트림의 데이터 소스는 오직 터미널 오퍼네이션을 실행할 때에만 처리한다.
- 중개 오퍼레이션
  * Stream을 리턴한다.
  * Stateless / Stateful 오퍼레이션으로 더 상세하게 구분할 수도 있다. (대부분은 Stateless지만 distinct나 sorted 처럼 이전 이전 소스 데이터를 참조해야 하는 오퍼레이션은 Stateful 오퍼레이션이다.)
  * filter, map, limit, skip, sorted, ...
- 종료 오퍼레이션
  * Stream을 리턴하지 않는다.
  * collect, allMatch, count, forEach, min, max, ...
- 참고
  * https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
  * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html

## Stream API
- 걸러내기
  * Filter(Predicate)
  * 이름이 3글자 이상인 데이터만 새로운 스트림으로 
- 변경하기
  * Map(Function) 또는 FlatMap(Functi
  * 각각의 Post 인스턴스에서 String title만 새로운 스트림으로
  * List&lt;Stream&lt;String&gt;&gt;을 String의 스트림으로
- 생성하기
  * generate(Supplier) 또는 Iterate(T seed, UnaryOperator) 
  * 예) 10부터 1씩 증가하는 무제한 숫자 스트림
  * 예) 랜덤 int 무제한 스트림
- 제한하기
  * limit(long) 또는 skip(long)
  * 예) 최대 5개의 요소가 담긴 스트림을 리턴한다.
  * 예) 앞에서 3개를 뺀 나머지 스트림을 리턴한다.
- 스트림에 있는 데이터가 특정 조건을 만족하는지 확인
  * anyMatch(), allMatch(), nonMatch()
  * 예) k로 시작하는 문자열이 있는지 확인한다. (true 또는 false를 리턴한다.)
  * 예) 스트림에 있는 모든 값이 10보다 작은지 확인한다.
- 개수 세기
  * count()
  * 예) 10보다 큰 수의 개수를 센다.
- 스트림을 데이터 하나로 뭉치기
  * reduce(identity, BiFunction), collect(), sum(), max()
  * 예) 모든 숫자 합 구하기
  * 예) 모든 데이터를 하나의 List 또는 Set에 옮겨 담기

## Optional 소개
- 자바 프로그래밍에서 NullPointerException을 종종 보게 되는 이유
  * null을 리턴하니까! && null 체크를 깜빡했으니까!
- 메소드에서 작업 중 특별한 상황에서 값을 제대로 리턴할 수 없는 경우 선택할 수 있는 방법
  * 예외를 던진다. (비싸다, 스택트레이스를 찍어두니까.)
  * null을 리턴한다. (비용 문제가 없지만 그 코드를 사용하는 클리어인트 코드가 주의해야 한다.)
  * (자바 8부터) Optional을 리턴한다. (클라이언트에 코드에게 명시적으로 빈 값일 수도 있다는 걸 알려주고, 빈 값인 경우에 대한 처리를 강제한다.)
- Optional
  * 오직 값 한 개가 들어있을 수도 없을 수도 있는 컨네이너.
- 주의할 것
  * 리턴값으로만 쓰기를 권장한다. (메소드 매개변수 타입, 맵의 키 타입, 인스턴스 필드 타입으로 쓰지 말자.) 
  * Optional을 리턴하는 메소드에서 null을 리턴하지 말자.
  * 프리미티브 타입용 Optional을 따로 있다. OptionalInt, OptionalLong,...
  * Collection, Map, Stream Array, Optional은 Opiontal로 감싸지 말 것.
- 참고
  * https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
  * https://www.oracle.com/technical-resources/articles/java/java8-optional.html
  * 이팩티브 자바 3판, 아이템 55 적절한 경우 Optional을 리턴하라.

## Optional API
- Optional 만들기
  * Optional.of()
  * Optional.ofNullable()
  * Optional.empty()
- Optional에 값이 있는지 없는지 확인하기
  * isPresent()
  * isEmpty() (Java 11부터 제공)
- Optional에 있는 값 가져오기
  * get()
  * 만약에 비어있는 Optional에서 무언가를 꺼낸다면??
- Optional에 값이 있는 경우에 그 값을 가지고 ~~를 하라.
  * ifPresent(Consumer)
  * 예) Spring으로 시작하는 수업이 있으면 id를 출력하라.
- Optional에 값이 있으면 가져오고 없는 경우에 ~~를 리턴하라.
  * orElse(T)
  * 예) JPA로 시작하는 수업이 없다면 비어있는 수업을 리턴하라.
- Optional에 값이 있으면 가져오고 없는 경우에 ~~를 하라.
  * orElseGet(Supplier)
  * 예) JPA로 시작하는 수업이 없다면 새로 만들어서 리턴하라.
- Optional에 값이 있으면 가졍고 없는 경우 에러를 던져라.
  * orElseThrow()
- Optional에 들어있는 값 걸러내기
  * Optional filter(Predicate)
- Optional에 들어있는 값 변환하기
  * Optional map(Function)
  * Optional flatMap(Function): Optional 안에 들어있는 인스턴스가 Optional인 경우에 사용하면 편리하다.

## Date와 Time 소개
- 자바 8에 새로운 날짜와 시간 API가 생긴 이유
  * 그전까지 사용하던 java.util.Date 클래스는 mutable 하기 때문에 thead safe하지 않다.
  * 클래스 이름이 명확하지 않다. Date인데 시간까지 다룬다.
  * 버그 발생할 여지가 많다. (타입 안정성이 없고, 월이 0부터 시작한다거나..)
  * 날짜 시간 처리가 복잡한 애플리케이션에서는 보통 [Joda Time](https://www.joda.org/joda-time/)을 쓰곤했다.
- 자바 8에서 제공하는 Date-Time API
  * [JSR-310](https://jcp.org/en/jsr/detail?id=310) 스팩의 구현체를 제공한다.
  * 디자인 철학
    * Clear
    * Fluent
    * Immutable
    * Extensible
- 주요 API
  * 기계용 시간 (machine time)과 인류용 시간(human time)으로 나눌 수 있다.
  * 기계용 시간은 EPOCK (1970년 1월 1일 0시 0분 0초)부터 현재까지의 타임스탬프를 표현한다.
  * 인류용 시간은 우리가 흔히 사용하는 연,월,일,시,분,초 등을 표현한다.
  * 타임스탬프는 Instant를 사용한다.
  * 특정 날짜(LocalDate), 시간(LocalTime), 일시(LocalDateTime)를 사용할 수 있다.
  * 기간을 표현할 때는 Duration (시간 기반)과 Period (날짜 기반)를 사용할 수 있다. 
  * DateTimeFormatter를 사용해서 일시를 특정한 문자열로 포매팅할 수 있다.
- 참고
  * https://codeblog.jonskeet.uk/2017/04/23/all-about-java-util-date/
  * https://docs.oracle.com/javase/tutorial/datetime/overview/index.html
  * https://docs.oracle.com/javase/tutorial/datetime/iso/overview.html

## Date와 Time API
- 지금 이 순간을 기계 시간으로 표현하는 방법
  * Instant.now(): 현재 UTC (GMT)를 리턴한다.
  * Universal Time Coordinated == Greenwich Mean Time

  ``` java
      Instant now = Instant.now();
      System.out.println(now);
      System.out.println(now.atZone(ZoneId.of("UTC")));

      ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
      System.out.println(zonedDateTime);
  ```

- 인류용 일시를 표현하는 방법
  * LocalDateTime.now(): 현재 시스템 Zone에 해당하는(로컬) 일시를 리턴한다.
  * LocalDateTime.of(int, Month, int, int, int, int): 로컬의 특정 일시를 리턴한다. 
  * ZonedDateTime.of(int, Month, int, int, int, int, ZoneId): 특정 Zone의 특정 일시를 리턴한다.
- 기간을 표현하는 방법
  * Period / Duration . beteen()
  
  ``` java
    Period between = Period.between(today, birthDay);
    System.out.println(between.get(ChronoUnit.DAYS));
  ```

- 파싱 또는 포매팅
  * 미리 정의해둔 포맷 참고 
  * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#predefined
  * LocalDateTime.parse(String, DateTimeFormatter);
  * Dateteme
  
  ``` java
        DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("MM/d/yyyy");
        LocalDate date = LocalDate.parse("07/15/1982", formatter);
        System.out.println(date);
        System.out.println(today.format(formatter));
  ```
  
- 레거시 API 지원
  * GregorianCalendar와 Date 타입의 인스턴스를 Instant나 ZonedDateTime으로 변환 가능.
  * java.util.TimeZone에서 java.time.ZoneId로 상호 변환 가능.
  
  ``` java
        ZoneId newZoneAPI = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone legacyZoneAPI = TimeZone.getTimeZone(newZoneAPI);

        Instant newInstant = new Date().toInstant();
        Date legacyInstant = Date.from(newInstant);
  ```
