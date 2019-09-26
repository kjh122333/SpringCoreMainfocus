package me.kjh.example_environment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * TestConfiguration
 */
@Configuration
@Profile("test")
public class TestConfiguration {

    @Bean
    public BookRepository bookRepository() {
        return new TestBookRepository();
    }
}   