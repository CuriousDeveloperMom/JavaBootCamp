package com.company.PritiSolankiU1M5Summative.dao;

import com.company.PritiSolankiU1M5Summative.model.Author;
import com.company.PritiSolankiU1M5Summative.model.Book;
import com.company.PritiSolankiU1M5Summative.model.Publisher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoJdbcTemplateImplTest {

    @Autowired
    protected BookDao bookDao;
    @Autowired
    protected AuthorDao authorDao;
    @Autowired
    protected PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {

        // clean out the test db

        List<Book> bList = bookDao.getAllBooks();

        bList.stream()
                .forEach(book -> bookDao.deleteBook(book.getBookId()));

        List<Author> aList = authorDao.getAllAuthors();

        aList.stream()
                .forEach(author -> authorDao.deleteAuthor(author.getAuthorId()));

        List<Publisher> pList = publisherDao.getAllPublishers();

        pList.stream()
                .forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisherId()));

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeleteBook() {

        Publisher publisher = new Publisher();
        publisher.setName("PERC");
        publisher.setStreet("Broad St");
        publisher.setCity("Savannah");
        publisher.setState("GA");
        publisher.setPostalCode("31401");
        publisher.setPhone("912-555-5555");
        publisher.setEmail("totallyrealemail@perc.com");

        publisher = publisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("Mark");
        author.setLastName("Juggernaut");
        author.setStreet("Hudson Ave");
        author.setCity("Harison");
        author.setState("NJ");
        author.setPostalCode("56567");
        author.setPhone("123-123-2222");
        author.setEmail("abcabcabc@yahoo.com");

        author = authorDao.addAuthor(author);

        Book book = new Book();
        book.setIsbn("0-1234-1234");
        book.setPublishDate(LocalDate.of(2000,10,16));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Alladin");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("12.25"));

        book = bookDao.addBook(book);


        Book book2 = bookDao.getBook(book.getBookId());
        assertEquals(book, book2);
        bookDao.deleteBook(book.getBookId());
        book2 = bookDao.getBook(book.getBookId());
        assertNull(book2);
    }

    @Test
    public void getAllBooks() {

        Publisher publisher = new Publisher();
        publisher.setName("PERC");
        publisher.setStreet("Broad St");
        publisher.setCity("Savannah");
        publisher.setState("GA");
        publisher.setPostalCode("31401");
        publisher.setPhone("912-555-5555");
        publisher.setEmail("totallyrealemail@perc.com");

        publisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("Mark");
        author.setLastName("Juggernaut");
        author.setStreet("Hudson Ave");
        author.setCity("Harison");
        author.setState("NJ");
        author.setPostalCode("56567");
        author.setPhone("123-123-2222");
        author.setEmail("abcabcabc@yahoo.com");

        authorDao.addAuthor(author);

        Book book = new Book();
        book.setIsbn("0-1234-1234");
        book.setPublishDate(LocalDate.of(2000,10,16));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Alladin");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("12.25"));

        bookDao.addBook(book);

        Book book1 = new Book();
        book.setIsbn("0-1111-1212");
        book.setPublishDate(LocalDate.of(2002,12,19));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Pinocio");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("15.50"));

        bookDao.addBook(book);

        List<Book> bookList = bookDao.getAllBooks();

        assertEquals(bookList.size(), 2);
    }

    @Test
    public void updateBook() {

        Publisher publisher = new Publisher();
        publisher.setName("PERC");
        publisher.setStreet("Broad St");
        publisher.setCity("Savannah");
        publisher.setState("GA");
        publisher.setPostalCode("31401");
        publisher.setPhone("912-555-5555");
        publisher.setEmail("totallyrealemail@perc.com");

        publisher = publisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("Mark");
        author.setLastName("Juggernaut");
        author.setStreet("Hudson Ave");
        author.setCity("Harison");
        author.setState("NJ");
        author.setPostalCode("56567");
        author.setPhone("123-123-2222");
        author.setEmail("abcabcabc@yahoo.com");

        author = authorDao.addAuthor(author);

        Book book = new Book();
        book.setIsbn("0-1234-1234");
        book.setPublishDate(LocalDate.of(2000,10,16));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Alladin");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("12.25"));

        book = bookDao.addBook(book);

        book.setIsbn("0-1234-4444");
        book.setPublishDate(LocalDate.of(2000, 10, 20));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Alladin");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal(25.00).setScale(2));

        bookDao.updateBook(book);

        Book book1 = bookDao.getBook(book.getBookId());

        assertEquals(book, book1);

    }
    @Test
    public void getBooksByAuthor() {

        Publisher publisher = new Publisher();
        publisher.setName("PERC");
        publisher.setStreet("Broad St");
        publisher.setCity("Savannah");
        publisher.setState("GA");
        publisher.setPostalCode("31401");
        publisher.setPhone("912-555-5555");
        publisher.setEmail("totallyrealemail@perc.com");

        publisher = publisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("Mark");
        author.setLastName("Juggernaut");
        author.setStreet("Hudson Ave");
        author.setCity("Harison");
        author.setState("NJ");
        author.setPostalCode("56567");
        author.setPhone("123-123-2222");
        author.setEmail("abcabcabc@yahoo.com");

        author = authorDao.addAuthor(author);

        Author author2 = new Author();
        author2.setFirstName("Ruth");
        author2.setLastName("Beese");
        author2.setStreet("Silver Ave");
        author2.setCity("Lodi");
        author2.setState("NJ");
        author2.setPostalCode("23234");
        author2.setPhone("123-123-1122");
        author2.setEmail("xyzxyz@yahoo.com");

        author2 = authorDao.addAuthor(author2);

        Author author3 = new Author();
        author3.setFirstName("Goldi");
        author3.setLastName("Mars");
        author3.setStreet("Sixth Ave");
        author3.setCity("Edison");
        author3.setState("NJ");
        author3.setPostalCode("45453");
        author3.setPhone("123-123-4444");
        author3.setEmail("asdacf@yahoo.com");

        author3 = authorDao.addAuthor(author3);

        Book book = new Book();
        book.setIsbn("0-1234-1234");
        book.setPublishDate(LocalDate.of(2000,10,16));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Alladin");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("15.75"));

        bookDao.addBook(book);

        Book book2 = new Book();
        book2.setIsbn("0-1234-1234");
        book2.setPublishDate(LocalDate.of(2000,10,18));
        book2.setAuthorId(author2.getAuthorId());
        book2.setTitle("Alladin");
        book2.setPublisherId(publisher.getPublisherId());
        book2.setPrice(new BigDecimal("15.50"));

        bookDao.addBook(book2);

        Book book3 = new Book();
        book3.setIsbn("0-1234-1234");
        book3.setPublishDate(LocalDate.of(2000,10,20));
        book3.setAuthorId(author3.getAuthorId());
        book3.setTitle("Alladin");
        book3.setPublisherId(publisher.getPublisherId());
        book3.setPrice(new BigDecimal("12.25"));

        bookDao.addBook(book3);

        List<Book> bList = bookDao.getBooksByAuthor(author.getAuthorId());
        assertEquals(1, bList.size());

        List<Book> cList2 = bookDao.getBooksByAuthor(author2.getAuthorId());
        assertEquals(1, cList2.size());

        List<Book> cList3 = bookDao.getBooksByAuthor(author3.getAuthorId());
        assertEquals(1, cList3.size());

    }

}