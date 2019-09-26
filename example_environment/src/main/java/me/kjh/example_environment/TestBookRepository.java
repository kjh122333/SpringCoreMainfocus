package me.kjh.example_environment;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * TestBookRepository
 */
@Repository
@Profile("test")
public class TestBookRepository implements BookRepository {

    
}


