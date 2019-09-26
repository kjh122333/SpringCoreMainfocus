/*  **************************************************************************************
    BookServiceRunner.java : 여러개의 Repository가 있을 경우 빈 설정이 안된다 따라서 해결 방안의
    3가지를 시각적으로 확인하기 위한 클래스입니다.
**************************************************************************************  */
package me.whiteship.example_autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class BookServiceRunner implements ApplicationRunner {

    // autowiredAnnotaionBeanPostPocessor.class 가 @Autowired를 동작((해당 빈을 찾는)하게 해준다
    @Autowired
    BookService bookService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        bookService.printBookRepository();
        // @Primary : [console]class me.whiteship.example_autowire.ManBookRepository
        // @Qualifier : [console]class me.whiteship.example_autowire.ManBookRepository
        //  List<BookRepository> bookRepositories : [console]
        //          me.whiteship.example_autowire.ManBookRepository@7d199c68
        //          me.whiteship.example_autowire.MyBookRepository@63411512
        //          class java.util.ArrayList
    }
}
