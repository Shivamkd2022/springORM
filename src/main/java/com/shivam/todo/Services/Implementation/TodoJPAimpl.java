package com.shivam.todo.Services.Implementation;

import com.shivam.todo.Daos.ToDoRepository;
import com.shivam.todo.Exceptions.ResourceNotFoundException;
import com.shivam.todo.Models.ToDo;
import com.shivam.todo.Services.ToDoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class TodoJPAimpl implements ToDoService {

    Logger logger= LoggerFactory.getLogger(TodoJPAimpl.class);
    @Autowired
    ToDoRepository toDoRepository;
    @Override
    public ToDo createTodo(ToDo t) {
        ToDo save = toDoRepository.save(t);
        logger.info("inserted {} ", save);
        return save;
    }

    @Override
    public ToDo getSingleTodo(int id) throws ResourceNotFoundException {
        ToDo singletodo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("invalid id entered"));
        logger.info("detail of item is: {}",singletodo);
        return singletodo;
    }

    @Override
    public List<ToDo> getAllTodos() {
        List<ToDo> all = toDoRepository.findAll();
        logger.info("list of items are: {} ",all);
        return all;
    }

    @Override
    public ToDo updateTodo(int todoId, ToDo todo) {
        ToDo updatetodo = toDoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("invalid id entered"));
        updatetodo.setTitle(todo.getTitle());
        updatetodo.setContent(todo.getContent());
        updatetodo.setStatus(todo.getStatus());
        updatetodo.setJsondate(todo.getJsondate());
        ToDo update = toDoRepository.save(updatetodo);
        logger.info("Updated: {}",update);
        return update;
    }

    @Override
    public void deleteTodo(int todoId) {
        toDoRepository.deleteById(todoId);
        logger.info("deleted");

    }
}
