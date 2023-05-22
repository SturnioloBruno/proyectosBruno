package com.example.fixture.repository;

import com.example.fixture.model.Partido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends MongoRepository<Partido, Long> {
}
