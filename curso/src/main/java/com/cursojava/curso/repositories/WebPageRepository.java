package com.cursojava.curso.repositories;

import com.cursojava.curso.entities.WebPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebPageRepository extends JpaRepository<WebPage, Long> {
}
