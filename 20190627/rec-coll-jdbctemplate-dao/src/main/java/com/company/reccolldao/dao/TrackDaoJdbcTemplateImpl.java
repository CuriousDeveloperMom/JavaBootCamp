package com.company.reccolldao.dao;

import com.company.reccolldao.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TrackDaoJdbcTemplateImpl implements TrackDao {


    @Override
    public Track addTrack(Track track) {
        return null;
    }

    @Override
    public Track getTrack(int id) {
        return null;
    }

    @Override
    public List<Track> getAllTracks() {
        return null;
    }

    @Override
    public List<Track> getTracksByAlbum(int albumId) {
        return null;
    }

    @Override
    public void updateTrack(Track track) {

    }

    @Override
    public void deleteTrack(int id) {

    }
}
