# ___IoC Container : `Bean's Scope`___ 
 - ___Scope___
    1. 싱글톤
    
        ```java
               @Component
               public class AppRunner implements ApplicationRunner {
                   //Single
                   @Autowired
                   Single single;
           
                   @Autowired
                   Proto proto;
           
                   @Override
                   public void run(ApplicationArguments args) throws Exception {
                       System.out.println(proto);
                       System.out.println(single.getProto());            
                   }
               }
        ```
           > `proto`, `single.getProto()` 둘은 같은 레퍼런스를 가리키고 있다.
            ```bash
               # proto
               me.kjh.example_beanscope.Proto@1a96d94c
               # single.getProto()
               me.kjh.example_beanscope.Proto@1a96d94c
            ```
        > 일단 Scope의 형태는 왠만하면 `Singleton`인데, 해당 인스턴스를 특정 스코프에 따라 만들려고 할때는 프로토타입으로 만들어야하는데 `Request`, `Session`, `WebSocket`, ...들은 proto type과 유사하다
    2. 프로토타입 
        1. `Request` 
        2. `Session` 
        3. `WebSocket` 
        4. ...
        
        - `Prototype` 선언 
        ```java
           @Component
           @Scope("prototype") //이 빈은 프로토 타입이다~
           public class Proto {
           }
        ```
        ```java
            @Override
            public void run(ApplicationArguments args) throws Exception {
                System.out.println("PROTO 1 : " + applicationContext.getBean(Proto.class));
                System.out.println("PROTO 2 : " + applicationContext.getBean(Proto.class));
                System.out.println("PROTO 3 : " + applicationContext.getBean(Proto.class));
        
                System.out.println("SINGLE 1 : " + applicationContext.getBean(Single.class));
                System.out.println("SINGLE 2 : " + applicationContext.getBean(Single.class));
                System.out.println("SINGLE 3 : " + applicationContext.getBean(Single.class));       
            }        
        ```
        ```bash 
            # 참조값이 다름
            PROTO 1 : me.kjh.example_beanscope.Proto@67064bdc
            PROTO 2 : me.kjh.example_beanscope.Proto@4a7fd0c9
            PROTO 3 : me.kjh.example_beanscope.Proto@18578491
            # 싱글톤은 같은 값을 참조함
            SINGLE 1 : me.kjh.example_beanscope.Single@3291b443
            SINGLE 2 : me.kjh.example_beanscope.Single@3291b443
            SINGLE 3 : me.kjh.example_beanscope.Single@3291b443              
        ```

 - 프로토타입 빈이 싱글톤 빈을 참조하면? : 아무 문제 없음. 
 - 싱글톤 빈이 프로토타입 빈을 참조하면? : 프로토타입 빈이 업데이트가 안되네? 
    - 업데이트 하려면...
        1. scoped-proxy 
        2. Object-Provider 
        3. Provider (표준) 
 - ___Proxy (프록시)[https://en.wikipedia.org/wiki/Proxy_pattern]___ 
 - ___싱글톤 객체 사용시 주의할 점___ 
    1. 프로퍼티가 공유. 
    2. `ApplicationContext` 초기 구동시 인스턴스 생성. 
