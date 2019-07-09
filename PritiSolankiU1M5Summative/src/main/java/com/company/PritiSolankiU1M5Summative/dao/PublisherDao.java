package com.company.PritiSolankiU1M5Summative.dao;

import com.company.PritiSolankiU1M5Summative.model.Publisher;

import java.util.List;

public interface PublisherDao {

    Publisher getPublisher(int id);

    List<Publisher> getAllPublishers();

    Publisher addPublisher(Publisher publisher);

    void updatePublisher(Publisher publisher);

    void deletePublisher(int id);


}
