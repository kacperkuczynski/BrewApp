package com.example.BrewApp_1.product;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT r.type FROM Product p JOIN p.recipe r GROUP BY r.type ORDER BY r.type")
    List<String> findRecipeType();

    @Query(value = "SELECT SUM(p.made) FROM Product p JOIN p.recipe r GROUP BY r.type ORDER BY r.type")
    List<Integer> findAmountMade();

    @Query(value = "SELECT SUM(p.made) FROM Product p JOIN p.recipe r WHERE r.type LIKE 'Jasne%' GROUP BY p.executed ORDER BY p.executed")
    List<Integer> findMade1();

    @Query(value = "SELECT p.executed FROM Product p JOIN p.recipe r WHERE r.type LIKE 'Pszeniczne%' group by p.executed order by p.executed")
    List<String> findDateMade1();

    @Query(value = "SELECT SUM(p.made) FROM Product p JOIN p.recipe r WHERE r.type LIKE 'Pszeniczne%' GROUP BY p.executed ORDER BY p.executed")
    List<Integer> findMade2();

    @Query(value = "SELECT SUM(p.made) FROM Product p JOIN p.recipe r WHERE r.type LIKE 'Ciemne%' GROUP BY p.executed ORDER BY p.executed")
    List<Integer> findMade3();
    @Query(value = "SELECT SUM(p.made) FROM Product p JOIN p.recipe r WHERE r.type LIKE 'Summer%' GROUP BY p.executed ORDER BY p.executed")
    List<Integer> findMade4();

    @Query(value = "SELECT p.executed FROM Product p JOIN p.recipe r group by p.executed order by p.executed")
    List<String> findDateMade();

    @Query(value = "SELECT DISTINCT w.name FROM Product p JOIN p.recipe r " +
            "JOIN r.recipeIngr i JOIN i.raw w GROUP BY w.name ORDER BY w.name DESC")
    List<String> findRawName();

}
