package sishya.springframework.spring5webapp.bootstrap;



import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sishya.springframework.spring5webapp.model.Author;
import sishya.springframework.spring5webapp.model.Book;
import sishya.springframework.spring5webapp.model.Publisher;
import sishya.springframework.spring5webapp.repositories.AuthorRepository;
import sishya.springframework.spring5webapp.repositories.BookRepository;
import sishya.springframework.spring5webapp.repositories.PublisherRepository;

/*
 * created by NR on 23 Sep 2018
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    AuthorRepository authorRepository;
    BookRepository bookRepository;
    PublisherRepository publisherRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //publisher Kalasuvadu
        Publisher publisher1 = new Publisher();
        publisher1.setName("Kalasuvadu");
        publisherRepository.save(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Wrox");
        publisherRepository.save(publisher2);

        //marcos
        Author marcos = new Author("Juan","Marcos");
        Book gunter = new Book("Gunter's Winterbook", "12345", publisher1);
        marcos.getBooks().add(gunter);
        gunter.getAuthors().add(marcos);

        authorRepository.save(marcos);
        bookRepository.save(gunter);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "23444", publisher2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
