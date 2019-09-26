package me.kjh.example_beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype") //이 빈은 프로토 타입이다~
//public class Proto {
//    /*
//        프로토타입안에서 싱글톤 빈을 쓰겠다고 해도
//        문제 없음! 싱글톤 인스턴스는 의도한데로 매번 같은
//        놈이 들어옴. 그래서 프로토타입은 부를때마다 다른 놈이지만 안에서
//        는 같은 싱글톤을 참조함
//    */
//    @Autowired
//    Single single;
//}

/*
    (중요) `Singleton Bean`에서 `Proto Bean`을 부르게 되면 바뀌지 않는다. 감싸고 있는게 싱글톤이니깐...
            그렇다면 이 문제(싱글 안의 프로토를 부르는)를 해결 하려면?
            (1) `proxyMode` | | 쉽지만 이해하기 어렵
            (2) `ObjectProvider<부를 Bean>`
            (3)

*/
/* (1) `proxyMode`
 * - `proxyMode = ScopedProxyMode.DEFAULT` : 기본값, 프록시모드를 사용하지 않곘다.
 * - `proxyMode = ScopedProxyMode.TARGET_CLASS` : 쉬즈라이브러리르 적용한 다이나믹 프록시가 적용됨.
 *                                                뜻 : 해당 Bean을 CLASS 기반의 Proxy로 감싸라
 *                                                `부르는 Bean`이 `부를 Bean`을 중간에 Proxy를 거처서 부름
 *
 * - `proxyMode = ScopedProxyMode.INTERFACES` : JDK 기반의 인터페이스기반의 프록시 적용
 * - `proxyMode = ScopedProxyMode.NO` :
 */
@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS) //이 빈은 프로토 타입이다~
public class Proto {
    /*
        프로토타입안에서 싱글톤 빈을 쓰겠다고 해도
        문제 없음! 싱글톤 인스턴스는 의도한데로 매번 같은
        놈이 들어옴. 그래서 프로토타입은 부를때마다 다른 놈이지만 안에서
        는 같은 싱글톤을 참조함
    */
    /*
    * 달라짐...
    * [console]
    * PROTO by SINGLE...
    * me.kjh.example_beanscope.Proto@33956d1a
    * me.kjh.example_beanscope.Proto@2e1ddc90
    * me.kjh.example_beanscope.Proto@5b7c8930
    * */
}