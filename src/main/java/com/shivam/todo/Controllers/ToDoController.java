package com.shivam.todo.Controllers;

import com.shivam.todo.Exceptions.ResourceNotFoundException;
import com.shivam.todo.Models.ToDo;
import com.shivam.todo.Services.Implementation.ToDoServiceInterfaceImplementaion;
import com.shivam.todo.Services.ToDoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todo")
public class ToDoController
{
    @Autowired
    private ToDoService tds;
    Logger logger= LoggerFactory.getLogger(ToDoController.class);
    // generating the random id
    Random random= new Random();

    @PostMapping("/create")
    public ResponseEntity<ToDo> createTodoHandler(@RequestBody ToDo t)
    {
        // creating todo
        // For NULL POINTER EXCEPTION
//        String str= null;
//        logger.info("The length of string is: {}", str.length());
        // For ARITHMETIC EXCEPTION
//        int a=2, b=0;
//        logger.info("The division is::{}", a/b);
        int id= random.nextInt(2500);
        t.setId(id);
        // creating date with system default current date.
        Date currentdate= new Date();
        t.setSimpledate(currentdate);
        logger.info("current date is: {}", currentdate );
        logger.info("todo date is {}", t.getJsondate());


    logger.info("one todo is created");
    // calling service to create todo.
        ToDo todo1 = tds.createTodo(t);
        ResponseEntity<ToDo>rs= new ResponseEntity<>(todo1, HttpStatus.CREATED);
        return rs;

    }

    // for getting all todos

    @GetMapping("/getall")
    public ResponseEntity<List<ToDo>>gettingTodoHandler()
    {
        List<ToDo> allTodos = tds.getAllTodos();
        ResponseEntity<List<ToDo>> rs= new ResponseEntity<>(allTodos,HttpStatus.OK);
        return rs;
    }

    // for getting single todo
    @GetMapping("/{todoId}")
    public ResponseEntity<ToDo> gettingSingleTodoHandler(@PathVariable("todoId") int id) throws ResourceNotFoundException {
        ToDo singleTodo = tds.getSingleTodo(id);
        ResponseEntity<ToDo> rs1= new ResponseEntity<>(singleTodo, HttpStatus.OK);
        return rs1;
    }

    @PutMapping("/{todoId}")
    // updating todo
    public ResponseEntity<ToDo> updateTodoHandler(@RequestBody ToDo todowithnewdetails,
                                                  @PathVariable int todoId)

    {
        ToDo updatetodo=tds.updateTodo(todoId, todowithnewdetails );

        ResponseEntity<ToDo> res2= new ResponseEntity<>(updatetodo,HttpStatus.OK);
        return res2;

    }
    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodoHandler(@PathVariable int todoId)
    {
        tds.deleteTodo(todoId);
        ResponseEntity<String> res4= new ResponseEntity<>("All the details of this id are deleted",HttpStatus.OK);
        return res4;

    }

//    @ExceptionHandler(value = {NullPointerException.class, ArithmeticException.class})
//    public ResponseEntity<String> nullPointerExceptionHandler(Exception ex)
//    {
//        logger.info("exception occured::::{}",ex.getMessage());
//        return new ResponseEntity<>("EXCEPTION OCCURED::"+ ex.getMessage(),HttpStatus.EXPECTATION_FAILED);
//    }


}
