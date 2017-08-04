package io.project.domain;

public class Task 
{

	private String name;
	private String description;
	private String status;
	
	public Task(String name, String description, String status) {
		this.name = name;
		this.description = description;
		this.status = status;
	}
	
	public Task()
	{
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", description=" + description + ", status=" + status + "]";
	}
	

}
