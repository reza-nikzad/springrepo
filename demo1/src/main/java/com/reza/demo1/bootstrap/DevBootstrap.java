package com.reza.demo1.bootstrap;

import com.reza.demo1.entities.Author;
import com.reza.demo1.entities.Book;
import com.reza.demo1.entities.Publisher;
import com.reza.demo1.repositories.AuthorsRepository;
import com.reza.demo1.repositories.BooksRepository;
import com.reza.demo1.repositories.PublishersRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorsRepository authorsRepository;
    private BooksRepository booksRepository;
    private PublishersRepository publishersRepository;

    public DevBootstrap(AuthorsRepository authorsRepository, BooksRepository booksRepository, PublishersRepository publishersRepository) {
        this.authorsRepository = authorsRepository;
        this.booksRepository = booksRepository;
        this.publishersRepository = publishersRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){

        Author eric = new Author("Eric" , "Evans");
        Book ddd = new Book("Domain Driven Design", "1234");
        Publisher pub = new Publisher("Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(pub);

        authorsRepository.save(eric);
        publishersRepository.save(pub);
        booksRepository.save(ddd);

        Author rod = new Author("Rod" , "Johnson");
        Book noEJB = new Book("J2EE Development Without EJB", "2344");
        Publisher pub2 = new Publisher("Time Reuters");

        rod.getBooks().add(noEJB);
        noEJB.setPublisher(pub2);

        authorsRepository.save(rod);
        publishersRepository.save(pub2);
        booksRepository.save(noEJB);
    }
}
