package com.shivam.todo;

import com.shivam.todo.Daos.TodoDao;
import com.shivam.todo.Models.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {
	Logger logger= LoggerFactory.getLogger(TodoManagerApplication.class);
	@Autowired
	private TodoDao todoDao;
	public static void main(String[] args)
	{
		SpringApplication.run(TodoManagerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Application is started.");
//		JdbcTemplate template = todoDao.getTemplate();
//		logger.info("Template object details: {}", template);

//		ToDo t= new ToDo();
//		t.setId(9102);
//		t.setTitle("Krishh");
//		t.setContent("Action Movie");
//		t.setStatus("hit");
//		t.setSimpledate(new Date());
//		t.setJsondate(new Date());
//		todoDao.saveTodo(t);


		// getting single todo
		//ToDo singleTodo = todoDao.getSingleTodo(2904);

		// getting all todos
 		// todoDao.getAllTodos();


		// updating todo
//		singleTodo.setTitle("Tubelight");
//		singleTodo.setContent("war based");
//		singleTodo.setStatus("super flop");
//		singleTodo.setSimpledate(new Date());
//		singleTodo.setJsondate(new Date());
//
//		todoDao.updateTodo(7710, singleTodo);

   		// deleting todo

		//todoDao.deleteTodo(7710);

		// deleting multiple todos

		//todoDao.deleteMultipleTodo(new int[]{52, 53, 54});
	}
}
