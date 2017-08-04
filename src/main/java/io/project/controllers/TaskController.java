package io.project.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.project.domain.Task;
import io.project.domain.User;
import io.project.repository.TaskRepository;

@RestController
public class TaskController 
{

	@Autowired
	TaskRepository taskRepository;
	
	@GetMapping("/add")
	public ModelAndView addTask(Model model)
	{
		model.addAttribute("task", new Task());
		System.out.println( model.toString());
		return new ModelAndView("addtask");
	}
	
	@RequestMapping("/taskadded")
	public ModelAndView showToDoList(@ModelAttribute Task task)
	{
		ArrayList<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task(task.getName(), task.getDescription(), "TO DO"));
		taskRepository.save(new User("bob", "123", tasks));
		System.out.println((new User("bob", "123", tasks)).toString());
		return new ModelAndView("taskadded");
	}
	
	@GetMapping("/tasks")
	public List<User> getTasks()
	{
		return (List<User>) taskRepository.findAll();
	}

}
