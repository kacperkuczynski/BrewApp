package com.example.BrewApp_1.raw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RawRepository extends JpaRepository<Raw, Long> {
    @Query(value = "SELECT w FROM Raw w WHERE w.id = :id")
    Raw findByRawId(Long id);

}
