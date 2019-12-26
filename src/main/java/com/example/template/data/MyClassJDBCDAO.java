package com.example.template.data;

import com.example.template.model.MyClass;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyClassJDBCDAO implements MyClassDAO {

    @Value("${db.url}")
    private String databaseURL;

    @Value("${db.username}")
    private String databaseUser;

    public List<MyClass> getMyClassData() {

        JdbcDataSource ds = new JdbcDataSource();
        ds.setUrl(databaseURL);
        ds.setUser(databaseUser);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        List<MyClass> results = new ArrayList<>();
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM sampleTab");

        while (sqlRowSet.next()) {
            MyClass myObject = new MyClass();
            myObject.setId(sqlRowSet.getInt("id"));
            myObject.setDescription(sqlRowSet.getString("description"));
            results.add(myObject);
        }

        return results;
    }
}
