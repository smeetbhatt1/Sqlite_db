package com.example.smeetbhatt.database1;

/**
 * Created by smeetbhatt on 10/09/17.
 */

public class Fruit {
    int id;
    String fruitName;

    public Fruit() {
    }

    public Fruit(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
}
