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

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoJdbcTemplateImplTest {

    @Autowired
    protected AuthorDao authorDao;

    @Before
    public void setUp() throws Exception {

        // clean out the test db

        List<Author> aList = authorDao.getAllAuthors();

        aList.stream()
                .forEach(author -> authorDao.deleteAuthor(author.getAuthorId()));

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeleteBook() {

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

        Author author1 = authorDao.getAuthor(author.getAuthorId());
        assertEquals(author, author1);
        authorDao.deleteAuthor(author.getAuthorId());
        author1 = authorDao.getAuthor(author.getAuthorId());
        assertNull(author1);

    }

    @Test
    public void getAllAuthors() {

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

        Author author1 = new Author();
        author1.setFirstName("John");
        author1.setLastName("Rodrics");
        author1.setStreet("Sixth Ave");
        author1.setCity("Clifton");
        author1.setState("NJ");
        author1.setPostalCode("12345");
        author1.setPhone("123-123-4444");
        author1.setEmail("xyzxyz@yahoo.com");

        authorDao.addAuthor(author1);

        List<Author> aList = authorDao.getAllAuthors();

        assertEquals(aList.size(), 2);

    }
    @Test
    public void updateAuthor() {

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

        author.setFirstName("John");
        author.setLastName("Rodrics");
        author.setStreet("Sixth Ave");
        author.setCity("Clifton");
        author.setState("NJ");
        author.setPostalCode("12345");
        author.setPhone("555-555-5555");
        author.setEmail("aaabbbccc@yahoo.com");

        authorDao.updateAuthor(author);
        Author author1 = authorDao.getAuthor(author.getAuthorId());
        assertEquals(author, author1);
    }

}