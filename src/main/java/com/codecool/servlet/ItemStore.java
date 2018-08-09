package com.codecool.servlet;

import java.util.ArrayList;
import java.util.List;

public class ItemStore {
    private static List<Item> listOfItems = new ArrayList<>();

    public static void add(Item newItem){
        listOfItems.add(newItem);
    }

    public static void remove(Item removeItem){
        listOfItems.remove(removeItem);
    }

    public static List<Item> getListOfItems(){
        return listOfItems;
    }


}
