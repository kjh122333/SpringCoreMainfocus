package me.whiteship.springapplicationcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service    //@Service : @Component를 받고 있음
// `ApplicationContext`를 사용해서 `BookService`와 `BookRepository`를 `Bean`으로 등록하자
public class BookService {

    @Autowired //@Autowired : 스프링에서 지원하는 `Bean` 주입,( = @inject)
    // 1. `BookService` 가 `BookRepository`를 사용한다
    BookRepository bookRepository;

    // 2. setter
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
