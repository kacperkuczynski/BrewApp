package com.example.BrewApp_1.recipe;

import com.example.BrewApp_1.product.Product;
import com.example.BrewApp_1.ingredient.Ingredient;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "recipe")
@RequiredArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numRec")
    private int numRec;
    @Column(name = "nameRec")
    private String nameRec;
    @Column(name = "type")
    private String type;
    @Column(name = "created")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private String created;
    @Column(name = "resultAmount")
    private double resultAmount;

    @Column(name = "resultExtract")
    private double resultExtract;


    //WRZENIE
    @Column(name = "boilTime")
    private int boilTime;


    //WHIRPOOL
    @Column(name = "timeWhirpool")
    private int timeWhirpool;

    @JsonManagedReference
    @OneToMany(mappedBy = "recipe", cascade = {CascadeType.MERGE, CascadeType.ALL})
    private List<Ingredient> recipeIngr;


    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Product> product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumRec() {
        return numRec;
    }

    public void setNumRec(int numRec) {
        this.numRec = numRec;
    }

    public String getNameRec() {
        return nameRec;
    }

    public void setNameRec(String nameRec) {
        this.nameRec = nameRec;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public double getResultAmount() {
        return resultAmount;
    }

    public void setResultAmount(double resultAmount) {
        this.resultAmount = resultAmount;
    }

    public double getResultExtract() {
        return resultExtract;
    }

    public void setResultExtract(double resultExtract) {
        this.resultExtract = resultExtract;
    }

    public int getBoilTime() {
        return boilTime;
    }

    public void setBoilTime(int boilTime) {
        this.boilTime = boilTime;
    }

    public int getTimeWhirpool() {
        return timeWhirpool;
    }

    public void setTimeWhirpool(int timeWhirpool) {
        this.timeWhirpool = timeWhirpool;
    }

    public List<Ingredient> getRecipeIngr() {
        return recipeIngr;
    }

    public void setRecipeIngr(List<Ingredient> recipeIngr) {
        this.recipeIngr = recipeIngr;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
