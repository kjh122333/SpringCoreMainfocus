package me.whiteship.example_autowire;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class ManBookRepository implements BookRepository{
}
