package ru.vyacheslav.javacoreprof.l1.ex3;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {

    private List <T> fruitBox = new ArrayList<>();

    void add (T fruit){
        fruitBox.add(fruit);
    }

    public double getWeight() {
        double totalWeight = 0;
        for (T fruit : fruitBox) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box box2) {
        return getWeight() == box2.getWeight();
    }

    public void moveFruits(Box<T> toBox){
        toBox.fruitBox.addAll(this.fruitBox);
        this.fruitBox.clear();
    }

}
