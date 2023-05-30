package com.shivam.todo.Services.Implementation;

import com.shivam.todo.Daos.TodoDao;
import com.shivam.todo.Exceptions.ResourceNotFoundException;
import com.shivam.todo.Models.ToDo;
import com.shivam.todo.Services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Primary
public class DaoTodoserviceImplementation implements ToDoService
{

    @Autowired
    private TodoDao todoDao;
    @Override
    public ToDo createTodo(ToDo t) {
        return todoDao.saveTodo(t);
    }

    @Override
    public ToDo getSingleTodo(int id) throws ResourceNotFoundException {
        return todoDao.getSingleTodo(id);
    }

    @Override
    public List<ToDo> getAllTodos() {
        return todoDao.getAllTodos();
    }

    @Override
    public ToDo updateTodo(int todoId, ToDo todo) {
        return todoDao.updateTodo(todoId, todo);
    }

    @Override
    public void deleteTodo(int todoId) {
        todoDao.deleteTodo(todoId);
    }
}
