package com.company.reccolldao.dao;

import com.company.reccolldao.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ArtistDaoJdbcTemplateImpl implements ArtistDao {


    @Override
    public Artist addArtist(Artist artist) {
        return null;
    }

    @Override
    public Artist getArtist(int id) {
        return null;
    }

    @Override
    public List<Artist> getAllArtists() {
        return null;
    }

    @Override
    public void updateArtist(Artist artist) {

    }

    @Override
    public void deleteArtist(int id) {

    }


}
