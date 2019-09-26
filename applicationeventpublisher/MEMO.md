# ___IoC Container : `ApplicationEventPublisher`___ 
 > Event Programming에 필요한 `ineterface` 제공. __옵저버 패턴 구현체__. 
### ApplicationContext extends ApplicationEventPublisher
  - publishEvent(ApplicationEvent event) 
### _Create Event_
 - `ApplicationEvent` 상속 
 - Spring 4.2 부터는 `ApplicationEvent` 클래스를 상속받지 않아도 이벤트로 사용할 수 있다. 
### _이벤트 발생 시키는 방법_ 
 - `ApplicationEventPublisher.publishEvent();` 
### _이벤트 처리하는 방법_ 
 - `ApplicationListener<E>` 구현한 클래스 만들어서 Bean으로 등록하기. 
 - Spring4.2 부터는 `@EventListener`를 사용해서 Bean의 메소드에 사용할 수 있다. 
 - 기본적으로는 `synchronized`. 
 - ___순서___ 를 정하고 싶다면 `@Order`와 함께 사용. 
 - ___비동기적___ 으로 실행하고 싶다면 `@Async`와 함께 사용. 
### _스프링이 제공하는 기본 이벤트_
| Event Name | ApplicationContext를... | 
|:---|:---|
|`ContextRefreshedEvent` | `초기화` 했더나 `리프래시` 했을 때 발생 | 
| `ContextStartedEvent` | `start()`하여 라이프사이클 빈들이 시작 신호를 받은 시점에 발생 | 
| `ContextStoppedEvent` | `stop()`하여 라이프사이클 빈들이 정지 신호를 받은 시점에 발생 | 
| `ContextClosedEvent` | `close()`하여 싱글톤 빈 소멸되는 시점에 발생 | 
| `RequestHandledEvent` | `HTTP 요청`을 처리했을 때 발생 | 
