package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    //sets up one-to-many relationship. Each category will have many cheeses, each each can have only 1 category
    @OneToMany //JPA annotation
    @JoinColumn(name = "category_id") //tells hibernate to use the category_id column to determine which cheese belongs to a category
    private List<Cheese> cheeses = new ArrayList<>();

    public Category() {
    }

    public Category(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getId() {
        return id;
    }
}
