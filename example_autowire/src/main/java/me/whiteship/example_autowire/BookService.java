package me.whiteship.example_autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


// 빈이 있거나 없는경우 ver 1,2,3 /////////////////////////////////////////////////////////////////////////////////////
//@Service
//public class BookService {
//    // ver 1
////@Autowired를 통한 주입
//BookRepository bookRepository;
//    @Autowired
//    public BookService(BookRepository bookRepository){
//        this.bookRepository = bookRepository;
//    }
//}

//@Service
//public class BookService {
//    // ver 2
// //@Autowired를 통한 주입
//BookRepository bookRepository;
//    @Autowired(required = false)
//    // setter
//    public void setBookRepository(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//}

//@Service
//public class BookService {
//    // ver 3
//    @Autowired(required = false)
//    BookRepository bookRepository;

//}

// 빈이 여러개일 경우 : 중 택 1 /////////////////////////////////////////////////////////////////////////////////////
//@Service
//public class BookService {
//    @Autowired
//    @Qualifier("manBookRepository") //@Qualifier("manBookRepository") : @Primary가 @Qualifier보다 타입세이프함
//    BookRepository bookRepository;
//
//    public void printBookRepository(){
//        System.out.println(bookRepository.getClass());
//    }
//}
// 빈이 여러개일 경우 : 모두 /////////////////////////////////////////////////////////////////////////////////////
@Service
public class BookService {
    @Autowired
    // BookRepository 타입의 모든 빈을 주입
    List<BookRepository> bookRepositories;

    public void printBookRepository() {

        this.bookRepositories.forEach(System.out::println);
        System.out.println(bookRepositories.getClass());
    }
}


/*
Description:
Field bookRepository in me.whiteship.example_autowire.BookService required a single bean, but 2 were found:
- manBookRepository: defined in file [C:\Users\DOUZONE_BIT_GJH\IdeaProjects\BackLectures\example_autowire\target\classes\me\whiteship\example_autowire\ManBookRepository.class]
- myBookRepository: defined in file [C:\Users\DOUZONE_BIT_GJH\IdeaProjects\BackLectures\example_autowire\target\classes\me\whiteship\example_autowire\MyBookRepository.class]
Action:
        Consider marking one of the beans as
        1. @Primary,
        2. updating the consumer to accept multiple beans,
        3. or using @Qualifier to identify the bean
        that should be consumed

    > 빈 주입시 여러개의 Repository가 생길 경우 주입이 불가능하기에 위 1~3의 해결책을 추천한다
        1. @Primary : 여러 가지 중 사용할 빈을 마킹해라
        2. updating the consumer to accept multiple beans : 모든 빈을 마킹해라
        3. using @Qualifier to identify the bean  : 원하는것을 마킹해라

*/

