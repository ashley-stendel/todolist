package io.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.project.domain.Task;
import io.project.domain.User;

public interface TaskRepository extends MongoRepository<User, String>
{

}
