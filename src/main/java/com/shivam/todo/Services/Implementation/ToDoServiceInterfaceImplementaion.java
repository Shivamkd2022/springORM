package com.shivam.todo.Services.Implementation;

import com.shivam.todo.Exceptions.ResourceNotFoundException;
import com.shivam.todo.Models.ToDo;
import com.shivam.todo.Services.ToDoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Component
@Service
public class ToDoServiceInterfaceImplementaion implements ToDoService
{
    Logger logger= LoggerFactory.getLogger(ToDoServiceInterfaceImplementaion.class);

    List<ToDo> l= new ArrayList<>();
    public ToDo createTodo(ToDo t)
    {
        l.add(t);
        logger.info("the details of todo is {}", this.l );
        return t;

    }

    public List<ToDo>getAllTodos()
    {
        return l;
    }

    public ToDo getSingleTodo(int id) throws ResourceNotFoundException {
       ToDo tdo= l.stream().filter(t-> id== t.getId()).findAny().orElseThrow(()-> new ResourceNotFoundException("Todo not found with given id", HttpStatus.NOT_FOUND));
       logger.info("Todo: {}",tdo);
       return tdo;

    }

    public ToDo updateTodo(int todoId,ToDo todo)
    {
        List<ToDo> updatedList= l.stream().map(t-> {
            if(t.getId()==todoId) {
                t.setTitle(todo.getTitle());
                t.setContent(todo.getContent());
                t.setStatus(todo.getStatus());
                // perform update
                return t;
            }
            else
             {
                return t;
            }
        }).collect(Collectors.toList());

        l= updatedList;
        todo.setId(todoId);
        return todo;
    }

    public void deleteTodo(int todoId)
    {
        logger.info("deleting todo");
        List<ToDo> newList = l.stream().filter(t -> todoId != t.getId()).collect(Collectors.toList());
        l= newList;


    }
}
