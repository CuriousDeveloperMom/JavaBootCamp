package com.company.reccolldao.dao;

import com.company.reccolldao.model.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LabelDaoJdbcTemplateImpl implements LabelDao {

    @Override
    public Label addLabel(Label label) {
        return null;
    }

    @Override
    public Label getLabel(int id) {
        return null;
    }

    @Override
    public List<Label> getAllLabels() {
        return null;
    }

    @Override
    public void updateLabel(Label label) {

    }

    @Override
    public void deleteLabel(int id) {

    }
}
