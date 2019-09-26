package me.spring.applicationeventpublisher;

import org.springframework.context.ApplicationEvent;

/*
 * `MyEvent.class`는 Bean 등록 X
 * 내가 원하는 데이터를 담아서 전송하는 역할
 * */

//public class MyEvent extends ApplicationEvent {
//
//    private int data;
//    /**
//     * Create a new ApplicationEvent.
//     *
//     * @param source the object on which the event initially occurred (never {@code null})
//     */
//    public MyEvent(Object source) {
//        super(source);
//    }
//
//    public MyEvent(Object source, int data) {
//        super(source);
//        this.data = data;
//    }
//
//    public int getData(){
//        return data;
//    }
//}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* 스프링 4.2 부터는 `ApplicationEvent`를 상속받지 않아도됨
 * 아래 클래스는 순수 자바 POJO 형태임(스프링 코드 X, 비침투성!)
 * 유지보수 쉬워짐
 *
 *  */
public class MyEvent {

    private Object source;
    private int data;

    public MyEvent(Object source, int data) {
        this.source = source;
        this.data = data;
    }

    public Object getSource() {
        return source;
    }

    public int getData() {
        return data;
    }
}

