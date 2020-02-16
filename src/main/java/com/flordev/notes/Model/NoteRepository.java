package com.flordev.notes.Model;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {

    Note findByTitle(String title);
    List<Note> findByUser(User user);
    Note findById(long id);


}

