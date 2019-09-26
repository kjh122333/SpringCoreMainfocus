package me.kjh.example_beanscope;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// //ver 1
//@Component
//public class Single {
////    Single 이 Proto를 가지고 있다
//    @Autowired
//    Proto proto;
////    getter
//    public Proto getProto() {
//        return proto;
//    }
//
//}

/*
    (중요) 만약에 `Singleton Bean`에서 `Proto Bean`을 부르게 되면
*/
@Component
public class Single {
//    //    Single 이 Proto를 가지고 있다
//    @Autowired
//    private Proto proto;
//    //    getter
//    public Proto getProto() {
//        return proto;
//    }

    /* (2) `ObjectProvider<부를 Bean>`
     * 이 방법보다는 불러질 곳(Bean)에서 자신의 형태를 지정해주는 것이 가독성이나 다방면으로
     * 낫디 ( !!! POJO 스럽지 못하다 )
     *
     * !!! Bean들 중에서도 짧은 주기의 Bean과 롱런하는 Bean이 존재하는데 이것들 어떻게 조화롭게 설정할
     * 것인지는 개발자의 몫
     *  */
    @Autowired
    private ObjectProvider<Proto> protos;

    public Proto getProto() {
        return protos.getIfAvailable();
    }
    /* 결과값
     * [console]
     * PROTO by SINGLE...
     * me.kjh.example_beanscope.Proto@37c41ec0
     * me.kjh.example_beanscope.Proto@5399f6c5
     * me.kjh.example_beanscope.Proto@58437801
     * */

}
