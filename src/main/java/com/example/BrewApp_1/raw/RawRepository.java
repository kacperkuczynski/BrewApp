package com.example.BrewApp_1.raw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RawRepository extends JpaRepository<Raw, Long> {
    @Query(value = "SELECT w FROM Raw w WHERE w.id = :id")
    Raw findByRawId(Long id);

}
