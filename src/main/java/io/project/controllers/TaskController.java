package io.project.controllers;

import java.util.List;
import java.util.Map;

import javax.management.Query;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.project.domain.Task;
import io.project.domain.User;
import io.project.repository.UsersTaskRepository;

@RestController
public class TaskController 
{

	@Autowired
	UsersTaskRepository usersTaskRepository;
	
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		
		List<User> usersInfo = usersTaskRepository.findAll();
		Map<String, Object> model = new HashMap<String, Object>();
        model.put("userInfo", usersInfo);
        
        return new ModelAndView("home", model);
	}
	
	@ModelAttribute("usersInfo")
	public List<User> usersInfo()
	{
		return usersTaskRepository.findAll();
	}
	
	@GetMapping("/add")
	public ModelAndView addTask(Model model)
	{
		model.addAttribute("task", new Task());
		System.out.println( model.toString());
		return new ModelAndView("addtask");
	}
	
	@RequestMapping("/taskadded")
	public ModelAndView addTask(@ModelAttribute Task task)
	{
		String username = "bob";
		//get task object
		Task taskObj = new Task(task.getName(), task.getDescription(), "TO DO");

		//check if repository is empty
		//if so, create new user and add task 
		if (usersTaskRepository.findAll().isEmpty())
		{
			ArrayList<Task> tasks = new ArrayList<Task>();
			tasks.add(taskObj);
			usersTaskRepository.save(new User("bob", "123", tasks));
			return new ModelAndView("taskadded");
		}
		
		if (usersTaskRepository.findByUsername(username) == null)
		{
			ArrayList<Task> tasks = new ArrayList<Task>();
			tasks.add(taskObj);
			usersTaskRepository.save(new User("bob", "123", tasks));
			return new ModelAndView("taskadded");
		}
		
		//add new task to list
		usersTaskRepository.addTaskToList("bob", taskObj);

		return new ModelAndView("taskadded");
	}
	
	@RequestMapping("/updatetask")
	public ModelAndView updateTask(@RequestParam String taskName, @RequestParam String status)
	{
		usersTaskRepository.updateTask("bob", taskName, status);
		return new ModelAndView("taskupdated");
	}
	
	@RequestMapping("/deletetask")
	public ModelAndView updateTask(@RequestParam String taskName)
	{
		usersTaskRepository.deleteTask("bob", taskName);
		return new ModelAndView("taskdeleted");
	}

	@GetMapping("/tasks")
	public List<User> getTasks()
	{
		return (List<User>) usersTaskRepository.findAll();
	}

}
