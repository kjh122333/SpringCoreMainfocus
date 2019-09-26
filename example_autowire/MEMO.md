# ___IoC Container : `@Autowire`___

 > 필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다. 

 ## `@Autowired` 
  - `required` : 기본값은 true (따라서 못 찾으면 애플리케이션 구동 실패) 
  - 사용할 수 있는 위치 
     1. `생성자` (스프링 4.3 부터는 생략 가능)
     2. `setter`
     3. `field` 
  - 경우의 수 
    1. 해당 타입의 빈이 없는 경우 
    2. 해당 타입의 빈이 한 개인 경우 
    3. 해당 타입의 빈이 여러 개인 경우 
        - 빈 이름으로 시도, 
            1. 같은 이름의 빈 찾으면 해당 빈 사용 
            2. 같은 이름 못 찾으면 실패 
 - 같은 타입의 빈이 여러개 일 때 : `@Primary` 
 - 해당 타입의 빈 모두 주입 받기 : `@Qualifier` (빈 이름으로 주입) 
 - 동작 원리 
    - `빈 라이프사이클` 
        1. BeanPostProcessor : 새로 만든 빈 인스턴스를 수정할 수 있는 라이프 사이클 인터페이스 
    - `AutowiredAnnotationBeanPostProcessor` extends BeanPostProcessor : 스프링이 제공하는 `@Autowired`와 `@Value` 애노테이션 그리고 JSR-330의 `@Inject` 애노테이션을 지원하는 애노테이션 처리기.
    
---
# ___IoC Container : `@Component`& `Component Scan`___ 
 
 - `Component Scan` 주요 기능
    1. 스캔 위치 설정
    2. `filter` : 어떤 애노테이션을 스캔 할지 또는 하지 않을지 
 - `@Component`
    1. `@Repository`
    2. `@Service`
    3. `@Controller`
    4. `@Configuration` 
 - 동작 원리
    1. `@ComponentScan`은 스캔할 패키지와 애노테이션에 대한 정보
    2. 실제 스캐닝은 `ConfigurationClassPostProcessor`라는 `BeanFactoryPostProcessor`에 의해 처리 됨. 
 - Function을    사용한 `Bean` 등록 
    ```java
    public static void main(String[] args) { 
       
       new SpringApplicationBuilder().
       sources(Demospring51Application.class).
       initializers(
           (ApplicationContextInitializer<GenericApplicationContext>)applicationContext -> { 
                   applicationContext.registerBean(MyBean.class); 
               }
       ).run(args); 
   
   } 
    ```
    