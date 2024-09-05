package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.entity.Task;
import com.service.TaskService;

@Controller
public class TaskController {
	@Autowired
	TaskService serv;
	
	@GetMapping("/listall")
	public ResponseEntity<List<Task>> getall()
	{
		return ResponseEntity.ok(serv.getallTask());
	}
	
	@GetMapping("/complete")
	public ResponseEntity<List<Task>> getcompl()
	{
		return ResponseEntity.ok(serv.findAllCompletedTask());
	}
	
	@GetMapping("/incomplete")
	public ResponseEntity<List<Task>> getincompl()
	{
		return ResponseEntity.ok(serv.findAllInCompletedTask());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Task> createTask(@RequestBody Task task) { 
        return ResponseEntity.ok(serv.createNewTask(task)); 
    } 
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Task> updatetask(@PathVariable Long id, @RequestBody Task task)
	{
		task.setId(id);
		return ResponseEntity.ok(serv.updatetask(task));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deltask(@PathVariable Task id)
	{
		serv.deletetask(id);
		return ResponseEntity.ok(true);
	}
}
