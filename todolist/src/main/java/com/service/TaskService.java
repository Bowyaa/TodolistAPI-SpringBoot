package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Task;
import com.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	TaskRepository repo;
	
	public Task createNewTask(Task task)
	{
		return repo.save(task);		
	}
	
	public List <Task> getallTask()
	{
		return repo.findAll();
	}
	
	public Task findTaskbyId(Long id)
	{
		return repo.getById(id);
	}
	
	public List<Task> findAllCompletedTask()
	{
		return repo.findByCompletedTrue();
	}
	
	public List<Task> findAllInCompletedTask()
	{
		return repo.findByCompletedFalse();
	}
	
	public Task updatetask(Task task)
	{
		return repo.save(task);
	}
	
	public void deletetask(Task task) {
		repo.delete(task);
	}
	
}
