package io.project.repository;

import io.project.domain.Task;

//Custom Repository Interface
public interface UsersTaskRepositoryCustom 
{
	int addTaskToList(String username, Task task);
}
