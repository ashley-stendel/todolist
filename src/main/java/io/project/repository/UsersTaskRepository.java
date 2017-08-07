package io.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.project.domain.Task;
import io.project.domain.User;


public interface UsersTaskRepository extends MongoRepository<User, String>, UsersTaskRepositoryCustom
{
	public User findByUsername(String username);
}
