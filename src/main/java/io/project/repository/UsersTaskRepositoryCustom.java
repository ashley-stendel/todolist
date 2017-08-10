package io.project.repository;

import io.project.domain.Task;

//Custom Repository Interface
public interface UsersTaskRepositoryCustom 
{
	int addTaskToList(String username, Task task);
	
	int updateTask(String username, String taskName, String status);

	int deleteTask(String username, String taskName);
}
