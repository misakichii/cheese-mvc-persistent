package org.launchcode.models;

//import javax.persistence.*; can also be used
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    //sets up half of many to many relationship
    @ManyToMany
   //private List<Cheese> cheeses = new ArrayList<>();
    private List<Cheese> cheeses;

    public void addItem(Cheese item) {
        //adds item to the cheeses list
        cheeses.add(item);
    }

    //empty constructor
    public Menu(){}

    public Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
