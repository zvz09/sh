package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lilipo on 2017/2/21.
 */
@Service
public class DemoService {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<DemoEntity> getList(){
        String sql = "SELECT ID,NAME,AGE   FROM DEMO";
        return (List<DemoEntity>) jdbcTemplate.query(sql, new RowMapper<DemoEntity>(){
            @Override
            public DemoEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                DemoEntity demo = new DemoEntity();
                demo.setId(rs.getInt("ID"));
                demo.setName(rs.getString("Name"));
                demo.setAge(rs.getInt("AGE"));
                return demo;
            }

        });
    }
}
