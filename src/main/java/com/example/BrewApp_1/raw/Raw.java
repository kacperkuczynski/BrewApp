package com.example.BrewApp_1.raw;

import com.example.BrewApp_1.ingredient.Ingredient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "raw")
@RequiredArgsConstructor
public class Raw implements Serializable {
    private static final long serialVersionUID = 4L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "NAME")
    private String name;
    @Column(name = "UNITMEASURE")
    private String unitMeasure;
    @JsonManagedReference
    @OneToMany(mappedBy = "raw", cascade = {CascadeType.ALL})
    private List<Ingredient> rawIngr;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public List<Ingredient> getRawIngr() {
        return rawIngr;
    }

    public void setRawIngr(List<Ingredient> rawIngr) {
        this.rawIngr = rawIngr;
    }

}
