package me.whiteship.example_autowire;

import org.springframework.stereotype.Repository;

//@Repository
public interface BookRepository {


}

/*
FAILED
    Parameter 0 of constructor in
    me.whiteship.example_autowire.BookService required
    a bean of type 'me.whiteship.example_autowire.BookRepository' that
    could not be found.

    Action: Consider defining a bean of type 'me.whiteship.example_autowire.BookRepository'
            in your configuration.

    @Repository 등록해라~
 */


// 해당 타입의 빈이 없거나 있는경우의 repository /////////////////////////////////////////////////////////////////////

//package me.whiteship.example_autowire;
//
//import org.springframework.stereotype.Repository;
//
////@Repository
//public class BookRepository {
//
//
//}
//
///*
//FAILED
//    Parameter 0 of constructor in
//    me.whiteship.example_autowire.BookService required
//    a bean of type 'me.whiteship.example_autowire.BookRepository' that
//    could not be found.
//
//    Action: Consider defining a bean of type 'me.whiteship.example_autowire.BookRepository'
//            in your configuration.
//
//    @Repository 등록해라~
// */
