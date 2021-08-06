package com.example.craigslist;

import org.springframework.data.repository.CrudRepository;

//CRUD - Create, read, update, delete
public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
