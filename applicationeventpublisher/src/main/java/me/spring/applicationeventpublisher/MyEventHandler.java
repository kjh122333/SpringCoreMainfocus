package me.spring.applicationeventpublisher;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

///* 이벤트가 발생되면 도착지는 해당 클래스 */
//@Component
//public class MyEventHandler implements ApplicationListener<MyEvent> {
//    @Override
//    public void onApplicationEvent(MyEvent event) {
//        System.out.println("Get EVENT!, data is " + event.getData());
//    }
//}

////////////////////////////////////////////////////////////////////////////////
/* 이벤트 핸들러도 스프링에서 빈으로 등록하는 것만 있고 나머진 없도록 하는게 좋은 코드*/

/* 이벤트가 발생되면 도착지는 해당 클래스 */
@Component
public class MyEventHandler {

    @EventListener
    public void myOnApplicationEvent(MyEvent event) {
        System.out.println("Get EVENT!, data is " + event.getData());
    }
}

