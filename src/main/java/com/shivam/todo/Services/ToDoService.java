package com.shivam.todo.Services;

import com.shivam.todo.Exceptions.ResourceNotFoundException;
import com.shivam.todo.Models.ToDo;

import java.util.List;

public interface ToDoService
{
    public ToDo createTodo(ToDo t);
    public ToDo getSingleTodo(int id) throws ResourceNotFoundException;
    public List<ToDo> getAllTodos();
    public ToDo updateTodo(int todoId,ToDo todo);
    public void deleteTodo(int todoId);

}
