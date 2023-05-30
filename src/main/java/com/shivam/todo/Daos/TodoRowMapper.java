package com.shivam.todo.Daos;

import com.shivam.todo.Models.ToDo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoRowMapper implements RowMapper<ToDo>{
    @Override
    public ToDo mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        ToDo to= new ToDo();
        to.setId(rs.getInt("id"));
        to.setTitle(rs.getString("title"));
        to.setContent(rs.getString("content"));
        to.setStatus(rs.getString("status"));
        to.setSimpledate(rs.getDate("simpleDate"));
        to.setJsondate(rs.getDate("JsonDate"));


        return to;
    }
}
