package com.projekty.projekt1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NauczycielRepo extends JpaRepository<Nauczyciel,Long> {
    Optional<Nauczyciel> findNauczycielById(Long aLong);
}
