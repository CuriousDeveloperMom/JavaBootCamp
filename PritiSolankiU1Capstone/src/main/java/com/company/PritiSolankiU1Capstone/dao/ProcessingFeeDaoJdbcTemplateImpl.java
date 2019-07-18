package com.company.PritiSolankiU1Capstone.dao;

import com.company.PritiSolankiU1Capstone.model.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProcessingFeeDaoJdbcTemplateImpl implements ProcessingFeeDao{

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_PROCESSING_FEE_SQL =
            "select * from processing_fee where product_type = ?";


    @Autowired
    public ProcessingFeeDaoJdbcTemplateImpl(JdbcTemplate newjdbcTemplate) {
        this.jdbcTemplate = newjdbcTemplate;
    }

    @Override
    public ProcessingFee getFeesByProductType(String productType) {

            return jdbcTemplate.queryForObject(SELECT_PROCESSING_FEE_SQL, this::mapRowToProcessingFee, productType);

    }

    private ProcessingFee mapRowToProcessingFee(ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));
        return processingFee;
    }
}
