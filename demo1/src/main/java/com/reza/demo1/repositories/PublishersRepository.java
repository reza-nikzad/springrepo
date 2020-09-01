package com.reza.demo1.repositories;

import com.reza.demo1.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishersRepository extends JpaRepository<Publisher, Long> {
}
