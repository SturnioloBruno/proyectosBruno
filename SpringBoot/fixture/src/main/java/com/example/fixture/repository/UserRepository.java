package com.example.fixture.repository;

import com.example.fixture.model.Appuser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends MongoRepository<Appuser,Long> {
    Optional<Appuser> findByEmail(String email);
}
