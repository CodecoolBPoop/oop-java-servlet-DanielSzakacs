package com.codecool.servlet;

public class Item {
    private static int numberOfId;
    private int id;
    private String name;
    private double price;

    public Item(){
    }

    public Item(String name, double price){
        this.id = numberOfId++;
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getId(){
        return this.id;
    }
}
