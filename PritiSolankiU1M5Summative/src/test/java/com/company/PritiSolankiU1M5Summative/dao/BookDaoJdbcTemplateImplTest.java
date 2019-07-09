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
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoJdbcTemplateImplTest {

    @Autowired
    protected BookDao BookDao;
    @Autowired
    protected AuthorDao AuthorDao;
    @Autowired
    protected PublisherDao PublisherDao;

    @Before
    public void setUp() throws Exception {

        // clean out the test db

        List<Book> bList = BookDao.getAllBooks();

        bList.stream()
                .forEach(book -> BookDao.deleteBook(book.getBook_id()));

        List<Author> aList = AuthorDao.getAllAuthors();

        aList.stream()
                .forEach(author -> AuthorDao.deleteAuthor(author.getAuthor_id()));

        List<Publisher> pList = PublisherDao.getAllPublishers();

        pList.stream()
                .forEach(publisher -> PublisherDao.deletePublisher(publisher.getPublisher_id()));

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeleteCoffee() {

        Publisher publisher = new Publisher();
        publisher.setName("PERC");
        publisher.setStreet("Broad St");
        publisher.setCity("Savannah");
        publisher.setState("GA");
        publisher.setPostal_code("31401");
        publisher.setPhone("912-555-5555");
        publisher.setEmail("totallyrealemail@perc.com");

        publisher = PublisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirst_name("Mark");
        author.setLast_name("Juggernaut");
        author.setStreet("Hudson Ave");
        author.setCity("Harison");
        author.setState("NJ");
        author.setPostal_code("56567");
        author.setPhone("123-123-2222");
        author.setEmail("abcabcabc@yahoo.com");

        author = AuthorDao.addAuthor(author);

        Book book = new Book();
        book.setIsbn("0-1234-1234");
        book.setPublish_date("2000-10-16");
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Alladin");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(12.25);

        book = BookDao.addBook(book);


        Book book2 = BookDao.getBook(book.getBook_id());
        assertEquals(book, book2);
        BookDao.deleteBook(book.getBook_id());
        book2 = BookDao.getBook(book.getBook_id());
        assertNull(book2);


        /*Coffee coffee2 = CoffeeDao.getCoffee(coffee.getCoffee_id());
        assertEquals(coffee, coffee2);
        CoffeeDao.deleteCoffee(coffee.getCoffee_id());
        coffee2 = CoffeeDao.getCoffee(coffee.getCoffee_id());
        assertNull(coffee2);*/

    }


    ////////////////////////////////////////////////
    @Test
    public void getBook() {
    }

    @Test
    public void getAllBooks() {

        Publisher publisher = new Publisher();
        publisher.setName("PERC");
        publisher.setStreet("Broad St");
        publisher.setCity("Savannah");
        publisher.setState("GA");
        publisher.setPostal_code("31401");
        publisher.setPhone("912-555-5555");
        publisher.setEmail("totallyrealemail@perc.com");

        PublisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirst_name("Mark");
        author.setLast_name("Juggernaut");
        author.setStreet("Hudson Ave");
        author.setCity("Harison");
        author.setState("NJ");
        author.setPostal_code("56567");
        author.setPhone("123-123-2222");
        author.setEmail("abcabcabc@yahoo.com");

        AuthorDao.addAuthor(author);

        Book book = new Book();
        book.setIsbn("0-1234-1234");
        book.setPublish_date("2000-10-16");
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Alladin");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(12.25);

        BookDao.addBook(book);

        Book book = new Book();
        book.setIsbn("0-1111-1212");
        book.setPublish_date("2002-12-19");
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Pinocio");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(15.50);

        BookDao.addBook(book);

        List<Book> bookList = BookDao.getAllBooks();

        assertEquals(bookList.size(), 2);
    }

    @Test
    public void updateBook() {

        Publisher publisher = new Publisher();
        publisher.setName("PERC");
        publisher.setStreet("Broad St");
        publisher.setCity("Savannah");
        publisher.setState("GA");
        publisher.setPostal_code("31401");
        publisher.setPhone("912-555-5555");
        publisher.setEmail("totallyrealemail@perc.com");

        publisher = PublisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirst_name("Mark");
        author.setLast_name("Juggernaut");
        author.setStreet("Hudson Ave");
        author.setCity("Harison");
        author.setState("NJ");
        author.setPostal_code("56567");
        author.setPhone("123-123-2222");
        author.setEmail("abcabcabc@yahoo.com");

        author = AuthorDao.addAuthor(author);

        Book book = new Book();
        book.setIsbn("0-1234-1234");
        book.setPublish_date("2000-10-16");
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Alladin");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(12.25);

        book = BookDao.addBook(book);


        coffee.setName("UPDATED");
        coffee.setCount(65);
        coffee.setUnit_price(13.29);

        CoffeeDao.updateCoffee(coffee);

        Coffee coffee2 = CoffeeDao.getCoffee(coffee.getCoffee_id());

        assertEquals(coffee2, coffee);
    }
    @Test
    public void getBooksByAuthor() {

        // Need to add Publisher here

        Author author = new Author();
        author.setFirst_name("Mark");
        author.setLast_name("Juggernaut");
        author.setStreet("Hudson Ave");
        author.setCity("Harison");
        author.setState("NJ");
        author.setPostal_code("56567");
        author.setPhone("123-123-2222");
        author.setEmail("abcabcabc@yahoo.com");

        author = AuthorDao.addAuthor(author);

        Author author2 = new Author();
        author2.setFirst_name("Ruth");
        author2.setLast_name("Beese");
        author2.setStreet("Silver Ave");
        author2.setCity("Lodi");
        author2.setState("NJ");
        author2.setPostal_code("23234");
        author2.setPhone("123-123-1122");
        author2.setEmail("xyzxyz@yahoo.com");

        author2 = AuthorDao.addAuthor(author2);

        Author author3 = new Author();
        author3.setFirst_name("Goldi");
        author3.setLast_name("Mars");
        author3.setStreet("Sixth Ave");
        author3.setCity("Edison");
        author3.setState("NJ");
        author3.setPostal_code("45453");
        author3.setPhone("123-123-4444");
        author3.setEmail("asdacf@yahoo.com");

        author3 = AuthorDao.addAuthor(author3);

        Book book = new Book();
        book.setIsbn("0-1234-1234");
        book.setPublish_date("2000-10-16");
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Alladin");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(12.25);

        BookDao.addBook(book);

        Book book2 = new Book();
        book2.setIsbn("0-1234-1234");
        book2.setPublish_date("2000-10-16");
        book2.setAuthor_id(author.getAuthor_id());
        book2.setTitle("Alladin");
        book2.setPublisher_id(publisher.getPublisher_id());
        book2.setPrice(12.25);

        BookDao.addBook(book2);

        Book book3 = new Book();
        book3.setIsbn("0-1234-1234");
        book3.setPublish_date("2000-10-16");
        book3.setAuthor_id(author.getAuthor_id());
        book3.setTitle("Alladin");
        book3.setPublisher_id(publisher.getPublisher_id());
        book3.setPrice(12.25);

        BookDao.addBook(book3);

        List<Book> bList = BookDao.getBooksByAuthor(author.getAuthor_id());
        assertEquals(2, bList.size());

        List<Book> cList2 = BookDao.getBooksByAuthor(author2.getAuthor_id());
        assertEquals(1, bList.size());

        List<Book> cList3 = BookDao.getBooksByAuthor(author3.getAuthor_id());
        assertEquals(0, bList.size());

    }




    //////////////////////////////////////////////////////

    @Test
    public void addBook() {
    }



    @Test
    public void deleteBook() {
    }
}