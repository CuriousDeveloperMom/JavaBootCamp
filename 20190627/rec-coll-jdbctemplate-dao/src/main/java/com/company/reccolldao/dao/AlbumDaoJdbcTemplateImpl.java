package com.company.reccolldao.dao;

import com.company.reccolldao.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumDaoJdbcTemplateImpl implements AlbumDao {
    @Override
    public Album addAlbum(Album album) {
        return null;
    }

    @Override
    public Album getAlbum(int id) {
        return null;
    }

    @Override
    public List<Album> getAllAlbums() {
        return null;
    }

    @Override
    public void updateAlbum(Album album) {

    }

    @Override
    public void deleteAlbum(int id) {

    }
}
