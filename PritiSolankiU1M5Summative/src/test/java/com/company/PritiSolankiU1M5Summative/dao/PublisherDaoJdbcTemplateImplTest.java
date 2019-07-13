package com.company.PritiSolankiU1M5Summative.dao;

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
public class PublisherDaoJdbcTemplateImplTest {

    @Autowired
    protected PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {

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

        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisherId());
        assertEquals(publisher, publisher1);
        publisherDao.deletePublisher(publisher.getPublisherId());
        publisher1 = publisherDao.getPublisher(publisher.getPublisherId());
        assertNull(publisher1);

    }

    @Test
    public void getAllPublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("PERC");
        publisher.setStreet("Broad St");
        publisher.setCity("Savannah");
        publisher.setState("GA");
        publisher.setPostalCode("31401");
        publisher.setPhone("912-555-5555");
        publisher.setEmail("totallyrealemail@perc.com");

        publisherDao.addPublisher(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setName("MARK");
        publisher1.setStreet("Gold St");
        publisher1.setCity("Atlanta");
        publisher1.setState("GA");
        publisher1.setPostalCode("12233");
        publisher1.setPhone("123-444-5555");
        publisher1.setEmail("absabs@perc.com");

        publisherDao.addPublisher(publisher1);

        List<Publisher> pList = publisherDao.getAllPublishers();

        assertEquals(pList.size(), 2);
    }

    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("PERC");
        publisher.setStreet("Broad St");
        publisher.setCity("Savannah");
        publisher.setState("GA");
        publisher.setPostalCode("31401");
        publisher.setPhone("912-555-5555");
        publisher.setEmail("totallyrealemail@perc.com");

        publisher = publisherDao.addPublisher(publisher);

        publisher.setPhone("555-555-5555");
        publisher.setEmail("totallyfakeemail@perc.com");

        publisherDao.updatePublisher(publisher);
        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisherId());

        assertEquals(publisher, publisher1);
    }

}