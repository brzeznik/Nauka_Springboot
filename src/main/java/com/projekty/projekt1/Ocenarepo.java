package com.projekty.projekt1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ocenarepo extends JpaRepository<Oceny,Long> {

}
