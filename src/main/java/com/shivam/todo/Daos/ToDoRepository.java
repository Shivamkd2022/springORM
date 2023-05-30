package com.shivam.todo.Daos;

import com.shivam.todo.Models.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo,Integer>
{

}
