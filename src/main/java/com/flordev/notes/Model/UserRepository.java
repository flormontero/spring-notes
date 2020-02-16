package com.flordev.notes.Model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    Note findByName(String name);
    Note findById(long id);
}

