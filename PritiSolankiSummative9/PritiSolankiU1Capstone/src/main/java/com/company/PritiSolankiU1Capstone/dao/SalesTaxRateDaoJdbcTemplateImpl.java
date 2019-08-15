package com.company.PritiSolankiU1Capstone.dao;

import com.company.PritiSolankiU1Capstone.model.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SalesTaxRateDaoJdbcTemplateImpl implements SalesTaxRateDao{

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_SALES_TAX_RATE_SQL =
            "select * from sales_tax_rate where state = ?";


    @Autowired
    public SalesTaxRateDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public SalesTaxRate getRateByState(String state) {
        System.out.println("SalesTaxDaoImpl Class getStateByRate Method");
        try{
            System.out.println("getRateByState method Impl class");
            return jdbcTemplate.queryForObject(SELECT_SALES_TAX_RATE_SQL, this::mapRowToSalesTaxRate, state);
        }catch (EmptyResultDataAccessException e){
            System.out.println("Returning Null");
            return null;
        }
    }

    private SalesTaxRate mapRowToSalesTaxRate(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState(rs.getString("state"));
        System.out.println("In Row Mapper SalesTaxRateDaoImpl");
        System.out.println("State : " + rs.getString("state"));
        salesTaxRate.setRate(rs.getBigDecimal("rate"));
        System.out.println("Rate : " + rs.getBigDecimal("rate"));
        return salesTaxRate;
    }
}
