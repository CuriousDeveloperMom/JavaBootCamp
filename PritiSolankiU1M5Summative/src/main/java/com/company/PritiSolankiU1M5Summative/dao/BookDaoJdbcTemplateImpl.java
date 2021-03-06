package com.company.PritiSolankiU1M5Summative.dao;

import com.company.PritiSolankiU1M5Summative.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class BookDaoJdbcTemplateImpl implements BookDao{


        // Prepared statement strings
        private static final String INSERT_BOOK_SQL =
                "insert into book (isbn, publish_date, author_id, title, publisher_id, price) values (?, ?, ?, ?, ?, ?)";

        private static final String SELECT_BOOK_SQL =
                "select * from book where book_id = ?";

        private static final String SELECT_ALL_BOOKS_SQL =
                "select * from book";

        private static final String DELETE_BOOK_SQL =
                "delete from book where book_id = ?";

        private static final String UPDATE_BOOK_SQL =
                "update book set isbn = ?, publish_date = ?, author_id = ?, title = ?, publisher_id = ?, price = ? where book_id = ?";

        private static final String SELECT_BOOKS_BY_AUTHOR_SQL =
                "select * from book where author_id = ?";



        private JdbcTemplate jdbcTemplate;

        @Autowired
        public BookDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {

            this.jdbcTemplate = jdbcTemplate;
        }
//////////////////////////////////////////


    @Override
    public Book getBook(int id) {

        try {

            return jdbcTemplate.queryForObject(SELECT_BOOK_SQL, this::mapRowToBook, id);

        } catch (EmptyResultDataAccessException e) {
            // if nothing is returned just catch the exception and return null
            return null;
        }

    }

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query(SELECT_ALL_BOOKS_SQL, this::mapRowToBook);
    }

    @Override
    public List<Book> getBooksByAuthor(int author_id) {
        return jdbcTemplate.query(SELECT_BOOKS_BY_AUTHOR_SQL, this::mapRowToBook, author_id);
    }

    @Override
    @Transactional
    public Book addBook(Book book) {
            jdbcTemplate.update(INSERT_BOOK_SQL,
                    book.getIsbn(),
                    book.getPublishDate(),
                    book.getAuthorId(),
                    book.getTitle(),
                    book.getPublisherId(),
                    book.getPrice());

            int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

            book.setBookId(id);

            return book;
    }

    @Override
    public void updateBook(Book book) {
        System.out.println("In Impl Class in update method ");
            jdbcTemplate.update(UPDATE_BOOK_SQL,
                    book.getIsbn(),
                    book.getPublishDate(),
                    book.getAuthorId(),
                    book.getTitle(),
                    book.getPublisherId(),
                    book.getPrice(),
                    book.getBookId());
        System.out.println("Isbn" + book.getIsbn());
        System.out.println("Publisher Date" + book.getPublishDate());
        System.out.println("Author Id" + book.getAuthorId());
        System.out.println("Title" + book.getTitle());
        System.out.println("Publisher Id" + book.getPublisherId());
        System.out.println("Price" + book.getPrice());
        System.out.println("Book Id" + book.getBookId());
    }

    @Override
    public void deleteBook(int id) {

            jdbcTemplate.update(DELETE_BOOK_SQL, id);

    }


        // Helper methods
        private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setBookId(rs.getInt("book_id"));
            book.setIsbn(rs.getString("isbn"));
            book.setPublishDate(LocalDate.parse(rs.getString("publish_date")));
            book.setAuthorId(rs.getInt("author_id"));
            book.setTitle(rs.getString("title"));
            book.setPublisherId(rs.getInt("publisher_id"));
            book.setPrice(rs.getBigDecimal("price"));

            return book;
        }
    }
