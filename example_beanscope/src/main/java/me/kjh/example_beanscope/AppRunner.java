package me.kjh.example_beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    /* PROTO TYPE */
    @Autowired
    ApplicationContext applicationContext;

    /* SINGLE TYPE */
//    @Autowired
//    Single single;
//
//    @Autowired
//    Proto proto;
    /*
     * PROTO TYPE
     * */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("PROTO 1 : " + applicationContext.getBean(Proto.class));
        System.out.println("PROTO 2 : " + applicationContext.getBean(Proto.class));
        System.out.println("PROTO 3 : " + applicationContext.getBean(Proto.class));

        System.out.println("SINGLE 1 : " + applicationContext.getBean(Single.class));
        System.out.println("SINGLE 2 : " + applicationContext.getBean(Single.class));
        System.out.println("SINGLE 3 : " + applicationContext.getBean(Single.class));

        System.out.println("PROTO by SINGLE...");
        System.out.println(applicationContext.getBean(Single.class).getProto());
        System.out.println(applicationContext.getBean(Single.class).getProto());
        System.out.println(applicationContext.getBean(Single.class).getProto());
        /* [console]
        * PROTO by SINGLE...
        * me.kjh.example_beanscope.Proto@4b74b35
        * me.kjh.example_beanscope.Proto@4b74b35
        * me.kjh.example_beanscope.Proto@4b74b35
        * */
    }
    /*
     * SINGLETON TYPE
     * */
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        //AppRunner 가 가지고 온 proto
//        System.out.println("proto : " + proto);
//        // single이 가지고 있는 proto
//        System.out.println("single.getProto() : " + single.getProto());
//        /*
//         * [console]
//         * me.kjh.example_beanscope.Proto@1a96d94c
//         * me.kjh.example_beanscope.Proto@1a96d94c
//         *  > `proto`, `single.getProto()` 둘은 같은 레퍼런스를 가리키고 있다.
//         *
//         * 일단 Scope의 형태는 왠만하면 `Singleton`
//         *
//         * 해당 인스턴스를 특정 스코프에 따라 만들려고 할때는 프로토타입으로 만들어야하는데
//         * Request, Session, WebSocket, ...들은 proto type과 유사하다다
//         * */
//
//    }
}
