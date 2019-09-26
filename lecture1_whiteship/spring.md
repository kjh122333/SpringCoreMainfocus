# ___`Spring Framework` Core Technology___

## _Goal_
 - _Spring Framework Core Technology_ ( `IoC`, `AOP`, `PSA` )을 이해합니다.
 - _Spring Framework_ __`IoC container`__ 의 다양한 기능을 사용할 수 있습니다.
 - 다양한 방법으로 __`Bean`__ 을 정의하고 의존 관계를 주입할 수 있습니다.
 - Spring __`AOP`__ 를 사용하여 Aspect를 모듈화 할 수 있습니다.
 - 그밖에 다양한 스프링 핵심 기술을 이해하고 또 활용할 수 있습니다.

---

## _setting lecture_ 
 - `JDK` _1.8_ , _11_
 - `Maven`
 - IDE : `IntelliJ`

---

## _Lectures_ 
 
### _※ 소개_
#### __강좌 및 스프링 소개__
 > `Spring` : 소규모 애플리케이션 또는 기업용 애플리케이션을 `JAVA`로 개발하는데 있어 유용하고 편리한 기능을 제공하는 `Framework`

 - 스프링의 역사
   - 2003년에 등장
   - Java EE와 호환 관계
   - 서블릿 기반의 애플리케이션을 만들 때 사용됨
   - Spring 5부터 서버 애플리케이션 개발도 가능해짐
 - How to Spring Design
   - 모든 선택의 개발자의 몫(스프링이 특정 영속화 기술을 강요하는 것이 아님)
   - 다양한 관점을 지향(유연성)
   - 하위 호환성을 지키자
   - 신중한 API 설계
   - 높은 수준의 코드를 지향

---

### _※ IoC 컨테이너와 빈_
#### __IoC 컨테이너 1부: 스프링 IoC 컨테이너와 빈__
- ___IoC___ ( _Inversion of Control, 의존 관계 주입_ ) : 어떤 객체가 사용하는 의족 객체를 직접 만들어 사용하는게 아니라, ___주입 받아 사용하는 방법___ 을 말함.
- 초기에는 .xml파일로 작성하는게 대세였으나, 점점 @어노테이션을 작성하는 것으로 바뀜
- ___Spring Ioc Container___
  - Bean Factory
  - Application compnent의 중앙 저장소
  - Bean Setting source로 부터 Bean Defind을 읽고, Bean을 구성하고 제공함
- ___Bean___ : `IoC Container`가 관리하는 객체( `@Service`, `@Repository`, ...) = ___Bean___
  - 스프링 IoC 컨테이너가 관리 하는 객체 ( 의존성 주입을 받기위해서 Bean이 되어야됨 )
    - 장점 : 의존성 관리 
    - 스코프
      - 싱글톤 : 하나
        - Spring IoC에 등록되는 Bean들은 일반적으로 싱글톤 스코프로 등록됨
        - 일반 getter setter만 있으면 javabean
      - 프로포토타입 : 매번 다른 객체 
    - Lifecycle Interface 를 지원해줌
 - ApplicationContext 
   - `BeanFactory`
   - 메시지 소스 처리 기능 (i18n)
   - 이벤트 발행 기능
   - 리소스 로딩 기능 
   - ... 

> 의존성 주입을 하게 되면 기존에 `new~ ` 해서 작성한 코드는 의존성으로 인해 안좋음

 - 스프링 IoC 컨테이너의 역할 
    - 빈 인스턴스 생성 
    - 의존 관계 설정 
    - 빈 제공 
 - AppcliationContext 
    - ClassPathXmlApplicationContext (XML) 
    - AnnotationConfigApplicationContext (Java) 
 - 빈 설정
    - 빈 명세서
    - 빈에 대한 정의를 담고 있다
    - 이름 
    - 클래스 
    - 스코프 
    - 생성자 아규먼트 (constructor) 
    - 프로퍼트 (setter) 
    - .. 
 - 컴포넌트 스캔 
    - 설정 방법 
      - XML 설정에서는 context:component-scan 
      - 자바 설정에서 @ComponentScan 
    - 특정 패키지 이하의 모든 클래스 중에 @Component 애노테이션을 사용한 클래스를 빈으로 자동으로 등록 해 줌. 



#### __IoC 컨테이너 2부 : ApplicationContext와 다양한 빈 설정 방법__

- `application.xml` : 의존 주입시 아래 방법은 좋지 않음
    ```xml
         <bean id="bookService" class="me.whiteship.springapplicationcontext.BookService">
            <!--`bookService` 가 `bookRepository`를 받게 하려면-->
            <property name="bookRepository" ref="bookRepository"/>
        <bean/>
        <!-- autowire="" : 타입과 이름, 생성자, 안한다, 의 리스트가 있음 -->
        <bean id="bookRepository" class="me.whiteship.springapplicationcontext.BookRepository"/>
    ```


#### __IoC 컨테이너 3부 : @Autowire__
#### __IoC 컨테이너 4부 : @Component와 컴포넌트 스캔__
#### __IoC 컨테이너 5부 : 빈의 스코프__
#### __IoC 컨테이너 6부 : Environment 1부. 프로파일__
#### __IoC 컨테이너 6부 : Environment 2부. 프로퍼티__
#### __IoC 컨테이너 7부 : MessageSource__
#### __IoC 컨테이너 8부 : ApplicationEventPublisher__
#### __IoC 컨테이너 9부 : ResourceLoader__

---

### _※ Resource / Validation_
#### __Resource 추상화__
#### __Validation 추상화__

---

### _※ 데이터 바인딩_
#### __데이터 바인딩 추상화 : PropertyEditor__
#### __데이터 바인딩 추상화 : Converter와 Formatter__

---

### _※ SpEL_
#### __SpEL (스프링 Expression Language)__

---

### _※ 스프링 AOP_
#### __스프링 AOP : 개념 소개__
#### __스프링 AOP : 프록시 기반 AOP__
#### __스프링 AOP : @AOP__

---

### _Null-Safety_
#### __Null-safety__

---

### _※ 마무리_
#### __outro__
