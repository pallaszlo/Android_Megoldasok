package com.example.pizzaselector;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private double basePrice;
    private boolean selected = false;
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public void addTopping(String name, double price){
        toppings.add(new Topping(name, price));
    }

    public void removeTopping(String name){
        toppings.removeIf(topping->topping.getName().equals(name));
    }

    public double getTotalPrice(){
        double totalPrice = this.basePrice;
        for(Topping item:toppings){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
