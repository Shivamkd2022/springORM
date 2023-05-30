package com.shivam.todo.Daos;

import com.shivam.todo.Models.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository 
public class TodoDao
{
    Logger logger= LoggerFactory.getLogger(TodoDao.class);
   // @Autowired
    private JdbcTemplate template;

    public TodoDao( @Autowired JdbcTemplate template) {
        this.template = template;
        // creating table if does not exist
        String createTable= "create table IF NOT EXISTS todos (id int primary key not null, title varchar(100) not null, content varchar(100), status varchar(20) not null, simpleDate date, JsonDate date)";
        int update = template.update(createTable);
        logger.info("TODO Table is created {}",update);


    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // saving the todo in the database

    public ToDo saveTodo (ToDo t1)
    {
        String insertQuery= "insert into todos (id, title, content, status, simpleDate, JsonDate) values (?,?,?,?,?,?)";
        int update = template.update(insertQuery, t1.getId(), t1.getTitle(), t1.getContent(), t1.getStatus(), t1.getSimpledate(), t1.getJsondate());
        logger.info("JDBC OPERATION: {} inserted",update);
        return t1;
    }

    // getting single todo from the database

    public ToDo  getSingleTodo (int id) {
        String query1 = "select * from todos where id= ?";
        ToDo toDo = template.queryForObject(query1, new TodoRowMapper(), id);
        // ToDo toDo = template.queryForObject(query1, new Object[]{id}, new BeanPropertyRowMapper<>(ToDo.class));
        logger.info("The detail of single todo is: {}", toDo);
        return toDo;
    }

            // getting all todos from the database
    public List<ToDo> getAllTodos ()
    {
        String query2= "select * from todos";
       //List<ToDo> todos= template.query(query2, new BeanPropertyRowMapper<>(ToDo.class));
        List<ToDo> todos = template.query(query2, new TodoRowMapper());
        logger.info("The details of all todos are: {}", todos);
       return todos;

    }

    // updating the todo
    public ToDo updateTodo (int id, ToDo t)
    {
        String query3= "update todos set title=?, content=?, status=?, simpledate=?, Jsondate=? where id= ? ";
        int update = template.update(query3, t.getTitle(), t.getContent(), t.getStatus(), t.getSimpledate(), t.getJsondate(), id );
        logger.info("TABLE UPDATED {} ",update);
        t.setId(id);
        return t;
    }

        public void deleteTodo (int id)
        {
            String query4= "delete from todos where id=?";
            int update = template.update(query4, id);
            logger.info("DELETED: {}",update);
        }

        public void deleteMultipleTodo(int[] ids)
        {
            String query= "delete from todos where id =?";
            int[] batchUpdate = template.batchUpdate(query, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    int id = ids[i];
                    ps.setInt(1, id);
                }

                @Override
                public int getBatchSize() {
                    return ids.length;
                }
            });

            for (int i:batchUpdate)
            {
                logger.info("DELETED: {}",i);

            }
        }

}
