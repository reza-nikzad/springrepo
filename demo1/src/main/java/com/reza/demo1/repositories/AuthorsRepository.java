package com.reza.demo1.repositories;

import com.reza.demo1.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Author, Long> {
}
