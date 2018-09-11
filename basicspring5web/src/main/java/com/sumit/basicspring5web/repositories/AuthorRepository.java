package com.sumit.basicspring5web.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sumit.basicspring5web.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
