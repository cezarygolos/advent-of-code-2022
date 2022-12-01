package com.adventofcode.day1;

public class Elf {

    private int totalCalories = 0;

    Elf(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    @Override
    public String toString() {
        return "Elf{" +
                "totalCalories=" + totalCalories +
                '}';
    }

    public int getTotalCalories() {
        return totalCalories;
    }
}
