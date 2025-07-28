package com.projekty.projekt1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Repozytorium extends JpaRepository<Student,Long> {

    Optional<Student> findStudentByEmail(String email);
}
