package me.whiteship.springapplicationcontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//ver 2
//@ComponentScan(basePackages = "me.whiteship.springapplicationcontext.")
@ComponentScan(basePackageClasses = DemoApplication.class)
public class ApplicationConfig {


//    //ver 1
//    //@Bean : 빈 정의 부분
//   @Bean
//    public  BookRepository bookRepository(){
//        return  new BookRepository();
//    }
//    @Bean
//    public BookService bookService(){
//        BookService bookService = new BookService();
//        bookService.setBookRepository(bookRepository());
//        return  bookService();
//    }
}
